package com.learn_spring_aop.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcutConfig {
	@Pointcut("execution(* com.learn_spring_aop.business.*.*(..))")
	public void businessPackageConfig() {}
	
	@Pointcut("execution(* com.learn_spring_aop.data.*.*(..))")
	public void dataPackageConfig() {}
	
	// Service가 들어가는 모든 bean
	@Pointcut("bean(*Service*)")
	public void allPackageConfigWithBean() {}
}
