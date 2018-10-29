package org.poor.framework.utils.email;

import org.poor.framework.utils.bean.SpringContextHolder;
import org.poor.framework.utils.properties.EmailProperties;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

/**
 * +---------------------------+
 * |I am the most handsome coding peasant.|
 * +---------------------------+
 * <p>Title: EmailUtil</p>
 * <p>Description: EmailUtil</p>
 * <p>Copyright:Copyright(c) coder 2018/p>
 * <p>Company: poor</p>
 * <p>CreateTime: 2018/10/29 15:23</p>
 * @author cb
 * @version 1.0
 **/
public class EmailUtil
{

    static
    {
        emailProperties = SpringContextHolder.getBean(EmailProperties.class);
    }

    private static EmailProperties emailProperties;
    private static final String HOST = emailProperties.getHost();
    private static final Integer PORT = emailProperties.getPort();
    private static final String USERNAME = emailProperties.getUsername();
    private static final String PASSWORD = emailProperties.getPassword();
    private static final String EMAIL_FORM = emailProperties.getFrom();
    private static final String TIMEOUT = emailProperties.getTimeout();
    private static final String PERSONAL = emailProperties.getPersonal();
    private static JavaMailSenderImpl mailSender = createMailSender();

    /**
     * <p>Description: 构建邮箱发送服务</p>
     * <p>Copyright:Copyright(c)2018</p>
     * <p>Company: poor</p>
     * <p>CreateTime:2018/10/29 15:43</p>
     * <p>@author cb</p>
     *
     * @version 1.0
     * @return JavaMailSenderImpl
     */
    private static JavaMailSenderImpl createMailSender()
    {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(HOST);
        sender.setPort(PORT);
        sender.setUsername(USERNAME);
        sender.setPassword(PASSWORD);
        sender.setDefaultEncoding("Utf-8");
        Properties p = new Properties();
        p.setProperty("mail.smtp.timeout", TIMEOUT);
        p.setProperty("mail.smtp.auth", "false");
        p.setProperty("mail.smtp.starttls.enable", "true");
        sender.setJavaMailProperties(p);
        return sender;
    }

    /**
     * <p>Description: 发送邮件</p>
     * <p>Copyright:Copyright(c)2018</p>
     * <p>Company: poor</p>
     * <p>CreateTime:2018/10/29 16:12</p>
     * <p>@author cb</p>
     *
     * @version 1.0
     * @param  to 接受人
     * @param  subject 主题
     * @param  html 发送内容
     * @throws MessagingException description
     * @throws UnsupportedEncodingException description
     */
    public static void sendMail(String to, String subject, String html) throws MessagingException, UnsupportedEncodingException
    {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 设置utf-8或GBK编码，否则邮件会有乱码
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        messageHelper.setFrom(EMAIL_FORM, PERSONAL);
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(html, true);
        mailSender.send(mimeMessage);
    }


}
