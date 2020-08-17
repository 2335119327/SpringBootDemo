package com.dong.task;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@SpringBootTest
class SpringTaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        //邮件设置
        message.setSubject("通知开会");
        message.setText("马上过来开会");

        //接收者
        message.setTo("网易云邮箱账号");
        //发送者
        message.setFrom("qq邮箱账号");

        mailSender.send(message);
    }

    @Test
    void test() throws MessagingException {
        //创建复杂的消息邮件
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        helper.setSubject("通知--今晚开会");
        helper.setText("<b style='color: red'>一定要准时开会</b>",true);

        //接收者
        helper.setTo("网易云邮箱账号");
        //发送者
        helper.setFrom("qq邮箱账号");

        //上传文件
        helper.addAttachment("1.png",new File("C:\\Users\\蓝色天空\\Pictures\\Saved Pictures\\1.png"));

        mailSender.send(mimeMessage);
    }

}
