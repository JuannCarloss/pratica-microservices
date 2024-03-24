package com.ms.email.services;

import com.ms.email.entities.Email;
import com.ms.email.enums.StatusEmail;
import com.ms.email.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EmailService {

    @Autowired
    private EmailRepository repository;
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String emailFrom;

    @Transactional
    public Email sendEmail(Email email){
        try{
            email.setEmailFrom(emailFrom);
            email.setEmailSendDate(LocalDateTime.now());

            var message = new SimpleMailMessage();

            message.setSubject(email.getSubject());
            message.setText(email.getBody());
            message.setTo(email.getEmailTo());
            mailSender.send(message);

            email.setStatusEmail(StatusEmail.SENT);
        }catch(MailException e){
            email.setStatusEmail(StatusEmail.ERROR);
        }
        return repository.save(email);
    }
}
