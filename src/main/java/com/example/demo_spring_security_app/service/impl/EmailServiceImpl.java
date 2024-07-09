package com.example.demo_spring_security_app.service.impl;

import com.example.demo_spring_security_app.dto.EmailDetails;
import com.example.demo_spring_security_app.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;

    //To use a property from application.properties file, you reference like this
    @Value("${spring.mail.username}")
    private String senderEmail;



    @Override
    public void sendEmailAlert(EmailDetails emailDetails) {
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

            simpleMailMessage.setFrom(senderEmail);
            simpleMailMessage.setTo(emailDetails.getRecipient());
            simpleMailMessage.setSubject(emailDetails.getSubject());
            simpleMailMessage.setText(emailDetails.getMessageBody());
          //there is no set attachment

            javaMailSender.send(simpleMailMessage);

            System.out.println("mail sent successfully");

        } catch (MailException e) {
            throw new RuntimeException("Email send failed");
        }

    }
}
