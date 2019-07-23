package com.springboot.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AspectExampleService {

	private Logger logger = LoggerFactory.getLogger(AspectExampleService.class);
	public String fetchValue()
	{
		logger.info("Enter in fetchValue");
		return "five";
	}
	
}
