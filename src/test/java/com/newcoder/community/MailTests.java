package com.newcoder.community;

import com.newcoder.community.util.MailClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * Created on 2022/4/24 -- 16:57.
 *
 * @author 金伸睿
 * @version 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MailTests {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testTextMail() {
        mailClient.sendMail("jinshenrui123@163.com", "TEST", "Hello,Spring Mail.I'm jsr");
    }

    @Test
    public void testHtmlMail() {
        //通过context对themleaf容器中添加键值对
        Context context = new Context();
        context.setVariable("username", "sunday");

        String content = templateEngine.process("/mail/demo", context);
        //templateEngine就是引擎用于跑请求地址，用context中的键值对
        //用键值对赋值之后，拿到这个content中的html内容
        System.out.println(content);
        //把content内容作为参数弄到这个里面去
        mailClient.sendMail("jinshenrui123@163.com", "HTML", content);
    }
}
