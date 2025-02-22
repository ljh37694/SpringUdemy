package com.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessImplStubTest {

	@Test
	void fineTheGreatestFromAllData_BasicScenario() {
		DataServiceStub dataServiceStub = new DataServiceStub();
		
		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
		
		int result = businessImpl.findTheGreatestFromAllData();
		
		assertEquals(123, result);
	}
}

class DataServiceStub implements DataService {
	@Override
	public int[] retrieveAllData() {
		
		return new int[]{ 1, 2, 3, 123, 31 };
	}
	
}