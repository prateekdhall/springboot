package com.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {

	private Logger logger = LoggerFactory.getLogger(UserAccessAspect.class);
	
	//This is pointcut
	@Before("execution(* com.springboot.aop.AspectExampleService (..))")
	public void before(JoinPoint joinPoint)
	{
		//This is Advice
		logger.info("Enter in UserAccessAspect");
		
	}
	
}
