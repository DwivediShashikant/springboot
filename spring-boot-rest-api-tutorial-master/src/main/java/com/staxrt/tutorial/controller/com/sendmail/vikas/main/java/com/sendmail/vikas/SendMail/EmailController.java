package com.sendmail.vikas.SendMail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
	@RequestMapping(value = "/sentoutlook", method = RequestMethod.GET)
	public String sendOutlook() {
		try {
			sentOutlook();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Outlook mail sent successfully ";
	}

	
	public void sentOutlook() throws MessagingException {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtprr.cerner.com");
			props.put("mail.smtp.port", "25");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.auth", "true");

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("vikas.dubey@cerner.com", "password");
				}
			});

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress("vikas.dubey@cerner.com", true));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("Santhosh.Niranjan@Cerner.com"));
			msg.setSubject("Approval Request for new Associate");
			msg.setContent("Please approve the following request..", "text/html");
			msg.setSentDate(new Date());

			MimeBodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent("Welcome to cerner", "text/html");

			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart);
			msg.setContent(multipart);
			Transport.send(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
