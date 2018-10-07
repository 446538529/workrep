package com.mideadc.component.mail;

import javax.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class SpringMail {
  private static final Logger logger = LoggerFactory.getLogger(SpringMail.class);
  private static final String HEADER_MESSAGE_ID = "Message-ID";

  public static String host = "smtp.exmail.qq.com";
  public static String username = "xx";
  public static String fromName = "xx";
  public static String password = "xx";
  public static int port = 25;

  /**
   * 发送邮件
   * 
   * @param title 邮件标题
   * @param content 邮件内容
   * @param to 邮件接收人
   * @return
   */
  public static String send(String title, String content, String to) {
    try {
      if (logger.isDebugEnabled()) {
        logger.debug("createSender with:host={},username={},port={}", new Object[] {host, username, port});
        logger.debug("createMail with:subject={},to={},fromName={}", new Object[] {title, to, fromName});
      }
      JavaMailSender sender = createSender(host, username, password, port);
      MimeMessagePreparator preparator = createMimeMessagePreparator(null, to, username, fromName, title, content);

      sender.send(preparator);
    } catch (MailException e) {
      logger.error("发送邮件时出现错误！", e);
      return e.getMessage();
    }
    return null;
  }

  private static MimeMessagePreparator createMimeMessagePreparator(final String msgId, final String to,
      final String from, final String fromName, final String subject, final String content) {
    MimeMessagePreparator preparator = new MimeMessagePreparator() {
      public void prepare(MimeMessage mimeMessage) throws Exception {
        if (msgId != null) {
          mimeMessage.setHeader(HEADER_MESSAGE_ID, msgId);
        }
        MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
        message.setTo(to);
        message.setFrom(from, fromName);
        message.setSubject(subject);
        message.setText(content, true);
      }
    };
    return preparator;
  }

  private static JavaMailSender createSender(String host, String username, String password, int port) {
    JavaMailSenderImpl sender = new JavaMailSenderImpl();
    sender.setDefaultEncoding("UTF-8");
    sender.setHost(host);
    sender.setUsername(username);
    sender.setPassword(password);
    sender.setPort(port);
    return sender;
  }

  public static void main(String[] args) {
    String title = "Mail test";
    String content = "this is mail <b>content</b>";
    String to = "xx";
    String result = SpringMail.send(title, content, to);
    System.err.println(result);
  }
}
