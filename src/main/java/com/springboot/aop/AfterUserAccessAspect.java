package com.springboot.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterUserAccessAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@After("execution(* com.springboot.aop.AspectExampleService (..))")
	public void afterLogic() {
		logger.info("Runs in two scenairos in both success and exceptions");
	}

	@AfterReturning("execution(* com.springboot.aop.AspectExampleService (..))")
	public void afterReturningLogic() {
		logger.info("Runs in only success scenarios");
	}

	@AfterThrowing("execution(* com.springboot.aop.AspectExampleService (..))")
	public void afterExceptionLogic() {
		logger.info("Runs in only exceptions scenarios");
	}
}
