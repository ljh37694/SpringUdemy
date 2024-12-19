package com.in28minutes.learn_spring_framework.examples.e1;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.GamingConsole;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	private SomeDependency someDependency;
	
	SomeClass(SomeDependency someDependency) {
		this.someDependency = someDependency;
		System.out.println("All dependencies are ready");
	}
	
	// Bean이 초기화되고 바로 실행
	@PostConstruct
	public void initialize() {
		someDependency.getReady();
	}
	
	// Bean이 삭제되기 직전에 실행
	@PreDestroy
	public void cleanup() {
		System.out.println("Cleanup");
	}
}

@Component 
class SomeDependency {
	public void getReady() {
		System.out.println("ready to start");
	}
}

@ComponentScan
public class PrePostAnnotationLauncherApplication {	
	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
					(PrePostAnnotationLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		}
	}
}
