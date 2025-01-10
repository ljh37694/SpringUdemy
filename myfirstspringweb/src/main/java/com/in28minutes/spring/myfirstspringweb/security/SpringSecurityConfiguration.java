package com.in28minutes.spring.myfirstspringweb.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {	
	@Bean
	public InMemoryUserDetailsManager createUserDetailsManger() {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		
		UserDetails userDetails1 = createNewUser("asdf", "asdf");
		
		String username = "";
		String password = "";
		UserDetails userDetails = createNewUser(passwordEncoder);
		
		return new InMemoryUserDetailsManager(userDetails);
	}

	private UserDetails createNewUser(Function<String, String> passwordEncoder) {
		UserDetails userDetails = User
				.builder()
				.passwordEncoder(passwordEncoder)
				.username("Lee")
				.password("asdfasdf")
				.roles("USER", "ADMIN")
				.build();
		
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	} 
}
