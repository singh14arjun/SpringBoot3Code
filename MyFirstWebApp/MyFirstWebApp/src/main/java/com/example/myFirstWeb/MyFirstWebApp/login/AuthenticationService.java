package com.example.myFirstWeb.MyFirstWebApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean authenticate(String userName, String password) {
		boolean isUser = userName.equalsIgnoreCase("arjun");
		boolean pass = password.equalsIgnoreCase("arjun12");
		return isUser && pass;
	}
}
