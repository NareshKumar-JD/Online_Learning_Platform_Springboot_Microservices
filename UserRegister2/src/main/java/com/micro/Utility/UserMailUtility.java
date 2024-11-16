package com.micro.Utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class UserMailUtility {

    @Autowired
    private JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String message) {
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setTo(to);
            mailMessage.setSubject(subject);
            mailMessage.setText(message);
            mailMessage.setFrom("your-email@example.com");  // Change to your sender email address

            javaMailSender.send(mailMessage);
        } catch (Exception e) {
            System.out.println("Error in sending email: " + e.getMessage());
            throw new RuntimeException("Error sending email to " + to);
        }
    }
}
