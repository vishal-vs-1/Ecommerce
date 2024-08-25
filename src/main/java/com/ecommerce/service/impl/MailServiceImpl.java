package com.ecommerce.service.impl;

import com.ecommerce.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MailServiceImpl implements MailService {

    private JavaMailSender mailSender;

    @Override
    public void subscribe(String email) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("noreply@baeldung.com");
            message.setTo(email);
            message.setSubject("Subscription Successful!");
            message.setText("Hello " + email + " thank you for subscribing with Shoppin");
        try{
            mailSender.send(message);
        } catch (MailException e) {
            System.out.println("error in sending mail");
            throw e;
        }
    }


}
