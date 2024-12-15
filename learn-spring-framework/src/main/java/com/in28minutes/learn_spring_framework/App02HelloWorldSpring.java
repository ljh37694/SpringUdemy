package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
	public static void main(String[] args) {
		// Launch a Spring Context
		var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		
		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("person"));
		System.out.println(context.getBean("customAddress"));
		
		// Address를 return하는 Bean이 여러개 있어서 오류 
		// @Primary or @Qualifier("asdfds") 오류해결
		System.out.println(context.getBean(Address.class));
		
		System.out.println(context.getBean("personMethodCall"));
		System.out.println(context.getBean("personParameter"));
	}
}
