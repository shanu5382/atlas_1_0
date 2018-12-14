/**
 * 
 */
package com.ge.atlas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ge.atlas.dto.MailDetails;
import com.ge.atlas.service.NotificationService;


/**
 * @author SHANU
 *
 */


@RestController
public class AtlasMailController {
	
	
	 @Autowired
	 NotificationService notificationService;
	
	 
	 @PostMapping(value="/Atlas/Notification")
	 @CrossOrigin(origins ="*")
	 public ResponseEntity<String> sendMail(@RequestBody MailDetails mailDetails) {
		 
		 String message = "";
		 try {
		 notificationService.sendMail(mailDetails);
		 
	     return  ResponseEntity.status(HttpStatus.OK).body(message);
		 }catch (Exception e) {
			 message = "error while sending mail";
				return  ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(message);
			} 
	 }
	
}
