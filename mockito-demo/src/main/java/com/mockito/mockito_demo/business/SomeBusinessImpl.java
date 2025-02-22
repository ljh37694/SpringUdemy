package com.mockito.mockito_demo.business;

public class SomeBusinessImpl {
	private DataService dataService;
	
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService = dataService;
	}

	public int findTheGreatestFromAllData() {
		int[] data = dataService.retrieveAllData();
		int answer = Integer.MIN_VALUE;
		
		for (int n : data) {
			answer = (n > answer) ? n : answer;
		}
		
		return answer;
	}
}

interface DataService {
	int[] retrieveAllData();
}