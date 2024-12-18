package com.in28minutes.learn_spring_framework.examples.b1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MySQLDataService implements DataService {
	@Override
	public int[] retrieveData() {
		return new int[] { 10, 20, 30, 40, 50 };
	}
}
