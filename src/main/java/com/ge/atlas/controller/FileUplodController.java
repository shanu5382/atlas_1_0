/**
 * 
 */
package com.ge.atlas.controller;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



/**
 * @author SHANU
 *
 */

@PropertySource("classpath:application.properties")
@RestController
public class FileUplodController {


	 @Value("${SECURE_CANONICAL_PATH}")
	    private String secure_canonical_path;
	
	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	 @PostMapping(value="/Atlas/File/Submission")
	 @CrossOrigin(origins ="*")
	 public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
		
		String msg = "";
		try {
			
		if (file != null ) {
			logger.info("File received : "+file.getOriginalFilename());
			File newFile = new File(secure_canonical_path+file.getOriginalFilename());
			FileUtils.copyInputStreamToFile(file.getInputStream(), newFile);
		  }
		    msg = "File uploaded successfully";
			return  ResponseEntity.status(HttpStatus.OK).body(msg);
		} catch (Exception e) {
			
			msg = "Fail to upload file ";
			return  ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(msg);
		
		}
		
	}

}
