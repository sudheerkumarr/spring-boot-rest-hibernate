package com.iprimed.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityApplication {

	static Logger logger = LoggerFactory.getLogger(SpringSecurityApplication.class);
	
	public static void main(String[] args) {
		logger.debug("**************Staring application**********");
		try {
			Thread.sleep(60);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

}
