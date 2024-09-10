package com.example.gerenciamento_eventos.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class NotifficationService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEventReminder(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
    }

    public void sendEventUpdateAlert(String to, String subject, String text) {
        sendEventReminder(to, subject, text);
    }
}
