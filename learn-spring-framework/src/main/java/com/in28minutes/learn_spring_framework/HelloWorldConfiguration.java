package com.in28minutes.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
	public Address address() {
		return new Address("경기도", "광주");
	}
}
