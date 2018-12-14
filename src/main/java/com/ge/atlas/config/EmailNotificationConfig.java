package com.ge.atlas.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.ge.atlas.service.AsyncMailSender;
import com.ge.atlas.serviceImpl.AsyncMailSenderImpl;



@Configuration
@PropertySource("classpath:application.properties")
public class EmailNotificationConfig {
	
	
	 @Value("${FROM_EMAIL_ADDRESSES}")
	 private String fromEmail;
	 @Value("${EMAIL_SERVER_HOST}")
	 private String emailServerHost;
	
	 @Value("${SMTP_CONNECTION_TIMEOUT}")
	 private String smtpConnTimeout;
	 @Value("${SMTP_TIMEOUT}")
	 private String smtpTimeout;
	 
	
	
	 @Bean
	 public AsyncMailSender asyncMailSenderImpl() {

		 return new AsyncMailSenderImpl();

	 }
	 
	 @Bean
	 public JavaMailSenderImpl javaMailSenderImpl() {
		 JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
		 javaMailSender.setHost(emailServerHost);
		 return javaMailSender;
	 }
	 
	 

}
