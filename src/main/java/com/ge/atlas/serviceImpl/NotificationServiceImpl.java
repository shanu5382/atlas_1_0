/**
 * 
 */
package com.ge.atlas.serviceImpl;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.ge.atlas.dto.MailDetails;
import com.ge.atlas.service.AsyncMailSender;
import com.ge.atlas.service.NotificationService;

/**
 * @author SHANU
 *
 */

@PropertySource("classpath:application.properties")
@Service("NotificationService")
public class NotificationServiceImpl implements NotificationService {

	 @Value("${FROM_EMAIL_ADDRESSES}")
	    private String fromAddress;
	 
	 @Autowired
	  private AsyncMailSender mailSender;
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public boolean sendMail(MailDetails mailDetails) throws Exception{
		
         boolean flag=false;
		
		try
		{
			logger.info("Sending mail to : "+mailDetails.getTo());
			logger.info("Sending mail cc : "+mailDetails.getCc());
			
				MimeMessage message = mailSender.createMimeMessage();
				message.setHeader("Content-Type", "text/html");
				if(mailDetails.getSubject() != null) {
				message.setSubject(mailDetails.getSubject());
				}else {
				message.setSubject("Atlas notification system");
				}
				message.setFrom(new InternetAddress(fromAddress));
				if(mailDetails.getTo() != null) {
				message.setRecipients(Message.RecipientType.TO, mailDetails.getTo());
				}else {
					throw new Exception("To Email address cannot be null");
				}
				message.setRecipients(Message.RecipientType.CC, mailDetails.getCc());

				MimeBodyPart messageBodyPart = new MimeBodyPart();
				
				messageBodyPart.setContent(mailDetails.getBody(),"text/html; charset=utf-8");
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messageBodyPart);
				message.setContent(multipart);
				message.saveChanges();
				
				mailSender.sendAsync(message);
				flag=true;
				}
				catch(MessagingException e)
				{
					flag=false;
					throw new MessagingException();
				}
		return flag;
	
	}

}
