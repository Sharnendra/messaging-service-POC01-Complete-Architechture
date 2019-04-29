package com.app.messagingservice.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.config.TransportStrategy;
import org.springframework.stereotype.Service;

@Service
public class MailingService {
	
	private Session mailSession;
	
	private void setMailServerProperties()
    {
        Properties emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", "587");
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");
        mailSession = Session.getInstance(emailProperties,  new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                System.out.println("Authenticating");
                return new PasswordAuthentication("Sharnendra.Dey@cognizant.com", "Kakkarotssj@6");
            }

        });
    }
	
	private MimeMessage draftEmailMessage() throws AddressException, MessagingException
    {
        String[] toEmails = { "sharnendradey@gmail.com" };
        String emailSubject = "Test email subject";
        String emailBody = "This is an email sent by <b>//howtodoinjava.com</b>.";
        MimeMessage emailMessage = new MimeMessage(mailSession);
        /**
         * Set the mail recipients
         * */
        for (int i = 0; i < toEmails.length; i++)
        {
            emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
        }
        emailMessage.setSubject(emailSubject);
        /**
         * If sending HTML mail
         * */
        emailMessage.setContent(emailBody, "text/html");
        /**
         * If sending only text mail
         * */
        //emailMessage.setText(emailBody);// for a text email
        return emailMessage;
    }
	
	public String sendMail(String emailId)
	{
		setMailServerProperties();
		/**
         * Sender's credentials
         * */
        String fromUser = "Sharnendra.Dey@cognizant.com";
        String fromUserEmailPassword = "Kakkarotssj@6";
 
        String emailHost = "smtp-mail.outlook.com";
        
        try {
        	Transport transport = mailSession.getTransport("smtp");
			transport.connect(emailHost, fromUser, fromUserEmailPassword);
			/**
	         * Draft the message
	         * */
	        MimeMessage emailMessage = draftEmailMessage();
	        /**
	         * Send the mail
	         * */
	        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
	        transport.close();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "Email sent successfully.";
	}
	
	private void mailer() {
		String fromUser = "Sharnendra.Dey@cognizant.com";
		String fromUserEmailPassword = "Kakkarotssj@6";

		String emailHost = "smtp-mail.outlook.com";
		org.simplejavamail.mailer.config.ServerConfig s = new org.simplejavamail.mailer.config.ServerConfig(emailHost,
				587, fromUser, fromUserEmailPassword);
		org.simplejavamail.mailer.config.ProxyConfig p = new org.simplejavamail.mailer.config.ProxyConfig(
				"proxy.cognizant.com", 6050, "767967", "Kakkarotssj@6");

		Mailer mailer = new Mailer(s, TransportStrategy.SMTP_TLS, p);

		mailer.sendMail(new EmailBuilder().from("mytest", "mytest@test.com").to("test", "sharnendradey@gmail.com")
				.subject("This is the subject line").textHTML("<h1>This is the actual message</h1>").build());

		System.out.println("Message sent...");
	}

}
