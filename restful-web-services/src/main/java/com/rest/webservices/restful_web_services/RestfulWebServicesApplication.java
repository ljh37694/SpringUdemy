package com.rest.webservices.restful_web_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.swagger.v3.oas.models.PathItem.HttpMethod;

@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
					.allowedMethods(
							HttpMethod.GET.name(),
			                HttpMethod.HEAD.name(),
			                HttpMethod.POST.name(),
			                HttpMethod.PUT.name(),
			                HttpMethod.DELETE.name())
					.allowedOrigins("http://localhost:3000")
					.allowCredentials(true)
					.allowedHeaders("*");
			}
		};
	}
}
