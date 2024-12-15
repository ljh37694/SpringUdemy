package com.in28minutes.learn_spring_framework.helloWorld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age) {}

record Address(String firstLine, String city) {}

@Configuration
public class HelloWorldConfiguration {
	@Bean
	public String name() {
		return "Mikasa";
	}
	
	@Bean
	public int age() {
		return 23;
	}
	
	@Bean
	public Person person() {
		return new Person("minsu", 10);
	}
	
	@Bean
	public Person personMethodCall() {
		return new Person(name(), age());
	}
	
	@Bean
	public Person personParameter(String name, int age) {
		return new Person(name, age);
	}
	
	@Bean(name = "customAddress")
	@Primary
	public Address address() {
		return new Address("경기도", "광주");
	}
	
	@Bean(name = "customAddress1")
	@Qualifier("address1Qualifier")
	public Address address1() {
		return new Address("서울", "특별시");
	}
}
