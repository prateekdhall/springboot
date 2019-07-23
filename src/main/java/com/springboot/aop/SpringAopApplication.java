package com.springboot.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAopApplication {

	private static Logger logger = LoggerFactory.getLogger(SpringAopApplication.class);
	public static void main(String[] args) {
		logger.info("Enter in SpringAopApplication");
		// TODO Auto-generated method stub
		SpringApplication.run(SpringAopApplication.class, args);
	}

}
