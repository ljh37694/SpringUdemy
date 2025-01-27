package com.rest.webservices.restful_web_services.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	
	@GetMapping("filtering")
	public MappingJacksonValue filtering() {
		SomeBean someBean = new SomeBean("value1", "value2", "value3");
		
		return applyFilter(someBean, "SomeBeanFilter", "field1", "field3");
	}
	
	@GetMapping("filtering-list")
	public MappingJacksonValue filteringList() {
		List<SomeBean> someBeanList = Arrays.asList(
				new SomeBean("value1", "value2", "value3"),
				new SomeBean("value1", "value2", "value3"),
				new SomeBean("value1", "value2", "value3"),
				new SomeBean("value1", "value2", "value3"));
		
		return applyFilter(someBeanList, "SomeBeanFilter", "field2", "field3");
	}
	
	private MappingJacksonValue applyFilter(Object value, String filterName, String... fieldsToKeep) {
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(value);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fieldsToKeep);
		FilterProvider filters = new SimpleFilterProvider().addFilter(filterName, filter);
		
		mappingJacksonValue.setFilters(filters);
		
		return mappingJacksonValue;
	}
}
