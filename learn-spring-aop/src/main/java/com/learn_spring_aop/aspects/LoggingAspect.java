package com.learn_spring_aop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private final String bussinessPointcut = "com.learn_spring_aop.aspects.CommonPointcutConfig.businessPackageConfig()";
	
	@Before(bussinessPointcut)
	public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
		logger.info("Before Aspect - Method is called - {}", joinPoint);
	}
	
	@After(bussinessPointcut)
	public void logMethodCallAfterExecution(JoinPoint joinPoint) {
		logger.info("After Aspect - {} has executed", joinPoint);
	}
	
	@AfterReturning(
			pointcut = bussinessPointcut,
			returning = "resultValue")
	public void logMethodCallAfterReturningExecution(JoinPoint joinPoint, Object resultValue) {
		logger.info("AfterReturning Aspect - {} has returned {}", joinPoint, resultValue);
	}
	
	@AfterThrowing(
			pointcut = bussinessPointcut,
			throwing = "exception")
	public void logMethodCallAfterThrowingExecution(JoinPoint joinPoint, Exception exception) {
		logger.info("AfterThrowing Aspect - {} has thorwn an exception {}", 
				joinPoint, exception);
	}
}
