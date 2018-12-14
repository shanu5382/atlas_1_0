package com.ge.atlas.service;

import java.io.InputStream;

import javax.mail.Session;
import javax.mail.internet.MimeMessage;

/**
 * Interface provided for asynchronous email sending.
 * 
 * Supports only MIME style email messages that must be created through the
 * factory method {@link #createMimeMessage()} so implementations must ensure
 * that the underlying {@link Session} is the same across all messages.
 * 
 * @author Shanu
 * 
 */
public interface AsyncMailSender {

	/**
	 * Creates a MIME style email message for the underlying JavaMail Session.
	 * 
	 * @return a new {@link MimeMessage}.
	 */
	MimeMessage createMimeMessage();
	
	/**
	 * Send the given JavaMail MIME message. The message needs to have been
	 * created with {@link #createMimeMessage()} or {@link #createMimeMessage(InputStream inputStream)}   
	 * to ensure that the underlying {@link Session} is the same across all messages.
	 * 
	 * @param message
	 *            - a MIME style message to be sent.
	 */
	void sendAsync(MimeMessage message);
}
