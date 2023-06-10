package com.spin.game.service;



import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

//import javax.mail.MessagingException;
//import javax.mail.internet.MimeMessage;

@Service
@AllArgsConstructor
public class EmailSenderService implements EmailSender{
    private final static Logger LOGGER = LoggerFactory.getLogger(EmailSenderService.class);
    private final JavaMailSender mailSender;
    @Override
    @Async
    public void send(String to, String email, String subject) {
        try{
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, "utf-8");
            mimeMessageHelper.setText(email, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setFrom("noreply@spingame.com");
            mailSender.send(mimeMessage);
        }
        catch(Exception e){
            LOGGER.error("Failed to send the email",e);
            throw new IllegalStateException();
        }
    }
}
