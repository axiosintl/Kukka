package com.example.sendmailwithattachment;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public void sendEmailWithAttachment(String toEmail, String subject, String body, MultipartFile file) throws jakarta.mail.MessagingException {
        jakarta.mail.internet.MimeMessage message = javaMailSender.createMimeMessage(); 

        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(body);

        // Attach the file
        helper.addAttachment(file.getName(), file);

        javaMailSender.send(message);
    }
}






