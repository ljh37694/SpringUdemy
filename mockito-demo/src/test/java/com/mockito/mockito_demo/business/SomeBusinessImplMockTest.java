package com.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {
	@Mock
	private DataService dataService;
	
	@InjectMocks
	private SomeBusinessImpl businessImpl;

	@Test
	void fineTheGreatestFromAllData_BasicScenario() {
		when(dataService.retrieveAllData()).thenReturn(new int[]{1, 3, 5, 123});		
		assertEquals(123, businessImpl.findTheGreatestFromAllData());
	}
	
	@Test
	void fineTheGreatestFromAllData_OneValue() {
		when(dataService.retrieveAllData()).thenReturn(new int[]{2312123});
		assertEquals(2312123, businessImpl.findTheGreatestFromAllData());
	}
	
	@Test
	void fineTheGreatestFromAllData_EmptyArray() {
		when(dataService.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
	}
}