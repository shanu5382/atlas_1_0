package com.ge.atlas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.ge.atlas.service.AsyncMailSender;
import com.ge.atlas.serviceImpl.AsyncMailSenderImpl;

@SpringBootApplication
public class AtlasApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtlasApplication.class, args);
	}
		
}

