package com.in28minutes.learn_spring_framework.examples.b1;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class MongoDbDataService implements DataService {
	@Override
	public int[] retrieveData() {
		return new int[] { 1, 2, 3, 4, 5 };
	}
}
