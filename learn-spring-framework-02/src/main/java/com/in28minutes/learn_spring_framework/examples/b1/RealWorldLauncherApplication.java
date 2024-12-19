package com.in28minutes.learn_spring_framework.examples.b1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;

@ComponentScan
public class RealWorldLauncherApplication {	
	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
					(RealWorldLauncherApplication.class)) {
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
		}
	}
}
