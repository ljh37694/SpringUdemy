package com.in28minutes.learn_spring_framework.examples.e1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;

@Configuration
@ComponentScan
public class SimpleSpringContextLauncherApplication {	
	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
					(SimpleSpringContextLauncherApplication.class)) {
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
		}
	}
}
