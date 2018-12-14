package com.ge.atlas.serviceImpl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.ge.atlas.service.AsyncMailSender;


public class AsyncMailSenderImpl implements AsyncMailSender {                       

	@Autowired
	private JavaMailSenderImpl mailSender;
	
	/**
	 * 
	 */
	public AsyncMailSenderImpl() {

	}
	
	/**
	 * {@inheritDoc}
	 */
	public MimeMessage createMimeMessage() {
		return mailSender.createMimeMessage();
	}


	public void sendAsync(final MimeMessage message) {
		mailSender.send(message);
	}

	

}
