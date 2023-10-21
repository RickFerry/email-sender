package com.ms.email.service;

import com.ms.email.model.Email;
import com.ms.email.model.enums.StatusEmail;
import com.ms.email.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmailService {
    private final EmailRepository emailRepository;
    private final JavaMailSender sender;
    @Value("${spring.mail.username}")
    private String emailFrom;

    public EmailService(EmailRepository emailRepository, JavaMailSender sender) {
        this.emailRepository = emailRepository;
        this.sender = sender;
    }

    public void sendEmail(Email email) {
        try {
            email.setSendDateEmail(LocalDateTime.now());
            email.setEmailFrom(emailFrom);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());

            sender.send(message);
            email.setStatusEmail(StatusEmail.SENT);
        } catch (Exception e) {
            email.setStatusEmail(StatusEmail.ERROR);
        }
        emailRepository.save(email);
    }
}
