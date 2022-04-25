package com.newcoder.community.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created on 2022/4/24 -- 16:07.
 *
 * @author 金伸睿
 * @version 1.0
 */
//因为相当于把发送请求的功能给新浪做，所以这个相当于是个客户端[链接]利用Yolov5实现旋转框目标检测（数据处理部分） - HAN&DAI
@Component
public class MailClient {

    //静态常量对象 单例且不更改
    private static final Logger logger = LoggerFactory.getLogger(MailClient.class);

    //spring组件的类 JavaMailSender
    //JavaMailSender主要就两个方法
    //第一个:createMimeMessage(InputStream val1) 返回MimeMessage 用邮件内容构造邮件主体
    //第二个:send(MimeMessage val) 发送邮件
    @Autowired
    private JavaMailSender mailSender;
    //这里由于发送者是统一的，所以定义为属性，而接受者是变化的，随方法变化，所以设置为参数
    @Value("${spring.mail.username}")
    private String from;
    //subject主题
    public void sendMail(String to, String subject, String content) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            //true为支持html文本,可以解析html转换的字符串
            helper.setText(content, true);
            mailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            logger.error("发送邮件失败" + e.getMessage());
        }
    }

}
