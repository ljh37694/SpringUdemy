package com.in28minutes.learn_spring_framework.examples.c1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {
	
}

@Lazy
@Component
class ClassB {
	private ClassA classA;
	
	ClassB(ClassA classA) {
		this.classA = classA;
		System.out.println("init classA");
	}
	
	public void printSomething() {
		System.out.println("hello world!");
	}
}

@ComponentScan
public class LazyInitializationLauncherApplication {	
	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
					(LazyInitializationLauncherApplication.class)) {
			// Bean은 Eager(즉시 초기화)가 dafault이기 때문에 ClassB를 instance화 하지 않아도 ClassA가 초기화된다
			// @Lazy를 사용하면 ClassB가 instance화 됐을 때 ClassA가 초기화된다
			
			// 만약 Lazy를 사용했을 때 에러가 발생한다면 런타임 에러가 발생하고
			// 즉시 초기화일 때는 실행되기 전에 에러가 발생하기 때문에 Application이 싱행되지 않는다
			// 이러한 이유로 @Lazy는 특별한 경우가 아니라면 잘 사용하지 않는다
			System.out.println("initialization completed");
			
			context.getBean(ClassB.class).printSomething();
		}
	}
}
