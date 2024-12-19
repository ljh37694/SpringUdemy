package com.in28minutes.learn_spring_framework.examples.f1;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;

//@Component
@Named
class BussinessService {
	private DataService dataService;
	  
	public DataService getDataService() {
		return dataService;
	}

	//@Autowired
	@Inject
	public void setDataService(DataService dataService) {
		System.out.println("Setter Injection");
		this.dataService = dataService;
	}
}

//@Component
@Named
class DataService {
	
}

@ComponentScan
public class CdiContextLauncherApplication {	
	public static void main(String[] args) {
		try(var context = 
				new AnnotationConfigApplicationContext
					(CdiContextLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println(context.getBean(BussinessService.class).getDataService());
		}
	}
}
