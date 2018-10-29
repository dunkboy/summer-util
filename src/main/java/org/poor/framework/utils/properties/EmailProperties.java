package org.poor.framework.utils.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: EmailProperties</p>
 * <p>Description: EmailProperties</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/10/29 15:34</p>
 * @author cb
 * @version 1.0
 **/
@Data
@Component
@ConfigurationProperties(prefix = "email")
public class EmailProperties
{
    /**
     * 服务器
     */
    private String host;

    /**
     * 端口
     */
    private Integer port;

    /**
     * 邮箱账号
     */
    private String username;

    /**
     * 邮箱授权密码
     */
    private String password;

    /**
     * 超时时间
     */
    private String timeout;

    /**
     * 发送者
     */
    private String from;

    /**
     * 系统名称
     */
    private String personal;

}
