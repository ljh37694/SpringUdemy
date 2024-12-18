package com.in28minutes.learn_spring_framework.examples.b1;

import java.util.Arrays;

import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService {
	DataService dataService;
	
	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}
	
	public BusinessCalculationService(DataService dataService) {
		super();
		this.dataService = dataService;
	}
}
