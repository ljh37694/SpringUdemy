package com.in28minutes.learn_spring_framework.examples.a1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class YourBussiness {
	// 1. dependency injection하고 싶은 변수 이름 위에 @Autowired를 넣는다
	
	//@Autowired
	Dependency1 dependency1;
	
	//@Autowired
	Dependency2 dependency2;
	
	// 2. setter에 @Autowired를 추가
//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		System.out.println("Setter Injection - setDependency1");
//		this.dependency1 = dependency1;
//	}
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		System.out.println("Setter Injection - setDependency2");
//		this.dependency2 = dependency2;
//	}
	
	// 3. constructor를 사용하면 자동으로 Dependency Injection이 이루어진다 (@Autowired는 option)
	// constructor를 사용해 의존성 주입하는 것이 더 간편하기 때문에 추천됨
	public YourBussiness(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
		
		System.out.println("Constructor Injection - YourBussiness");
	}
	
	public String toString() {
 		return "Using " + dependency1 + " and " + dependency2;
 	}
}

@Component
class Dependency1 {
	
}

@Component
class Dependency2 {
	
}

@Configuration
@ComponentScan // package가 같은 곳에 있다면 위치를 안 써도 됨
public class DepInjectionLauncherApplication {	
	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
					(DepInjectionLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);
			
			System.out.println(context.getBean(YourBussiness.class));
		}
	}
}
