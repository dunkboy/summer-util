package org.poor.framework.test.websoket;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.yeauty.annotation.OnBinary;
import org.yeauty.annotation.OnClose;
import org.yeauty.annotation.OnError;
import org.yeauty.annotation.OnEvent;
import org.yeauty.annotation.OnMessage;
import org.yeauty.annotation.OnOpen;
import org.yeauty.annotation.ServerEndpoint;
import org.yeauty.pojo.ParameterMap;
import org.yeauty.pojo.Session;


import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static io.netty.handler.timeout.IdleState.ALL_IDLE;
import static io.netty.handler.timeout.IdleState.READER_IDLE;
import static io.netty.handler.timeout.IdleState.WRITER_IDLE;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: WebSocketServer</p>
 * <p>Description: WebSocketServer</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/12/3 14:40</p>
 * @author cb
 * @version 1.0
 **/
@ServerEndpoint(prefix = "netty-websocket")
@Component
@Slf4j
public class WebSocketServer
{
    /**
     * 静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
     */
    private static final AtomicInteger ONLINE_COUNT = new AtomicInteger(0);

    /**
     * WebSocket 心跳测试数据
     */
    private static final String CONNECTING = "1";

    /**
     * 发送WebSocket异常
     */
    private final static String SESSION_ERROR = "发送WebSocket 消息异常";

    /**
     * 所有用户会话连接
     */
    private static final Map<String, CopyOnWriteArraySet<Session>> USER_SESSIONS = Maps.newConcurrentMap();

    /**
     * 当前会话连接
     */
    private Session session;

    /**
     * 当前发送消息的会话
     */
    private final static AtomicReference<Session> CUR_SESSION = new AtomicReference<>();

    /**
     * 当前用户id
     */
    private String userId;

    public WebSocketServer()
    {
    }

    @OnOpen
    public void onOpen(Session session, HttpHeaders headers, ParameterMap parameterMap)
    {
        String userId = parameterMap.getParameter("userId");
        log.info("###【用户id={}】", userId);
        // 新建链接对象
        this.session = session;
        this.userId = userId;

        synchronized (USER_SESSIONS)
        {
            Set<Session> sessions = USER_SESSIONS.get(userId);
            if (CollectionUtils.isEmpty(sessions))
            {
                CopyOnWriteArraySet<Session> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
                copyOnWriteArraySet.add(session);
                // 连接数加1
                int cnt = ONLINE_COUNT.incrementAndGet();
                log.info("有连接加入，当前连接数为：{}", cnt);
                USER_SESSIONS.put(userId, copyOnWriteArraySet);
                return;
            }
            sessions.add(session);
            // 连接数加1
            int cnt = ONLINE_COUNT.incrementAndGet();
            log.info("有连接加入，当前连接数为：{}", cnt);
        }
    }


    @OnClose
    public void onClose()
    {
        remove(session);
    }


    @OnMessage
    public void onMessage(String message, Session session)
    {
        sendSessionText(session, CONNECTING);
    }


    @OnError
    public void onError(Session session, Throwable error)
    {

        remove(session);
    }

    /**
     * 删除会话
     */
    private void remove(Session session)
    {

        synchronized (USER_SESSIONS)
        {
            Set<Session> sessions = USER_SESSIONS.get(userId);
            if (CollectionUtils.isEmpty(sessions))
            {
                USER_SESSIONS.remove(userId);
                return;
            }
            sessions.remove(session);
            // 连接数减1
            int cnt = ONLINE_COUNT.decrementAndGet();
            log.info("有连接关闭，当前连接数为：{}", cnt);
        }
    }

    /**
     * 获取指定用户的会话连接
     */
    public static Set<Session> findSessions(String userId)
    {

        if (null == userId)
        {
            return Sets.newHashSet();
        }
        return USER_SESSIONS.get(userId);
    }

    /**
     * 向指定会话,指定数据发送消息
     */
    public static void sendMessage(Set<Session> sessions, String message)
    {
        if (CollectionUtils.isEmpty(sessions) || StringUtils.isEmpty(message))
        {
            return;
        }
        sessions.forEach(session -> sendSessionText(session, message));
    }

    /**
     * 发送会话消息
     */
    private static void sendSessionText(Session session, String message)
    {
        if (null == session)
        {
            return;
        }
        if (!session.isOpen())
        {
            return;
        }

        synchronized (CUR_SESSION)
        {
            CUR_SESSION.set(session);
            try
            {
                CUR_SESSION.get().sendText(message);
            }
            catch (Exception e)
            {
                log.warn(SESSION_ERROR, e);
            }
        }
    }
}
