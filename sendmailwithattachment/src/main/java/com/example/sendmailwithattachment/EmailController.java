package com.example.sendmailwithattachment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/sendEmail")
    public String sendEmailWithAttachment(@RequestParam("to") String to,
                                          @RequestParam("subject") String subject,
                                          @RequestParam("text") String text,
                                          @RequestParam("file") MultipartFile file) throws jakarta.mail.MessagingException {
        emailService.sendEmailWithAttachment(to, subject, text, file);
        return "redirect:/success"; // Redirect to a success page or handle success as per your needs.
    }
}
