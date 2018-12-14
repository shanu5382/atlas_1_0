/**
 * 
 */
package com.ge.atlas.service;

import javax.mail.MessagingException;

import com.ge.atlas.dto.MailDetails;

/**
 * @author SHANU
 *
 */
public interface NotificationService {

	boolean sendMail(MailDetails mailDetails) throws MessagingException, Exception;

}
