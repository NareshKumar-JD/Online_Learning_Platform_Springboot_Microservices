package com.micro.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class PaymentMailUtility {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);
        mailMessage.setFrom("nareshkumar16927@gmail.com");  
        javaMailSender.send(mailMessage);
        System.out.println("Email sent to: " + to);
    }
}
