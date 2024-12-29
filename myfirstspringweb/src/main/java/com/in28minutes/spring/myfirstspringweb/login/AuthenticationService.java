package com.in28minutes.spring.myfirstspringweb.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authentication(String name, String password) {
		boolean isValidName = name.equalsIgnoreCase("name");
		boolean isValidPassword = password.equalsIgnoreCase("password");
		
		return isValidName && isValidPassword;
	}
}
