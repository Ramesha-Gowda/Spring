package com.learnspring.springbootmvc;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(public * com.learnspring.springbootmvc.AlienController.getAliens())")
	public void logBefore() {
		
		LOGGER.info("getAliens Method called from aspect ...");
	}
	
	@After("execution(public * com.learnspring.springbootmvc.AlienController.getAliens())")
	public void logAfter() {
		
		LOGGER.info("getAliens Method Executed after(finally) ...");
	}
	
	@AfterReturning("execution(public * com.learnspring.springbootmvc.AlienController.getAliens())")
	public void logAfterReturning() {
		
		LOGGER.info("getAliens Method Executed after returning ...");
	}
	
	@AfterThrowing("execution(public * com.learnspring.springbootmvc.AlienController.getAliens())")
	public void logAfterException() {
		
		LOGGER.info("getAliens Method Executed after throwing exception ...");
	}

}
