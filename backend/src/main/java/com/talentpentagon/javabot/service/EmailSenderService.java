package com.talentpentagon.javabot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String userEmail)
            throws MessagingException, jakarta.mail.MessagingException {
        jakarta.mail.internet.MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom("itdepartmentoracle@gmail.com");
        helper.setSubject("Password Reset Request");
        helper.setTo("itdepartmentoraclebot@hotmail.com");

        String htmlContent = "<html><body>" +
                "<p>We have received a password reset request from a user who seems to have forgotten their login credentials. Below are the details:</p>"
                +
                "<p><strong>User Email:</strong> " + userEmail + "</p>"
                +
                "<p><strong>Request:</strong> Password Reset</p>"
                +
                "<p>Reset their password for a new one and send them as soon as possible.</p>" +

                "<a href='https://postimages.org/' target='_blank'><img src='https://i.postimg.cc/G2j1BmSs/Blue-Modern-Email-Marketing-Facebook-Cover.png' border='0' alt='Blue-Modern-Email-Marketing-Facebook-Cover'/></a>"
                +
                "</body></html>";

        helper.setText(htmlContent, true);

        mailSender.send(message);

        System.out.println("Mail Sent Successfully...");
    }
}
