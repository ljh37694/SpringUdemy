package com.learn_spring_aop.business;

import java.util.Arrays;

import org.springframework.stereotype.Service;

import com.learn_spring_aop.data.DataService1;

@Service
public class BusinessService1 {
	private DataService1 dataService1;
	
	public BusinessService1(DataService1 dataService1) {
		super();
		this.dataService1 = dataService1;
	}

	public int findMax() {
		int[] data = dataService1.retrieveData();
		//throw new RuntimeException();
		return Arrays.stream(data).max().orElse(0);
	}
}
