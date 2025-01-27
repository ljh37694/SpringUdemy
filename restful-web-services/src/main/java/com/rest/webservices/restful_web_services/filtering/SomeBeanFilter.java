package com.rest.webservices.restful_web_services.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class SomeBeanFilter {
	private MappingJacksonValue mappingJacksonValue;
	private SimpleBeanPropertyFilter filter;
	private FilterProvider filters;
	
	public SomeBeanFilter(MappingJacksonValue mappingJacksonValue, SimpleBeanPropertyFilter filter,
			FilterProvider filters) {
		super();
		this.mappingJacksonValue = mappingJacksonValue;
		this.filter = filter;
		this.filters = filters;
	}
}
