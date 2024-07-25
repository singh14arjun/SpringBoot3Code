package com.springBoot.TodosApplication.security;

import java.util.function.Function;

import javax.print.DocFlavor.INPUT_STREAM;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;
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

	public InMemoryUserDetailsManager createUserDetailsManager() {
		
		
		UserDetails userDetails1 = createNewUser("arjun", "arjun12");
		UserDetails userDetails2 = createNewUser("arjun12", "arjun123");

		return new InMemoryUserDetailsManager(userDetails1,userDetails2);

	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> PasswordEncoder=input -> passWordEncoder().encode(input);
		
		
		UserDetails userDetails = User.builder().passwordEncoder(PasswordEncoder)
				.username(username).password(password)
				.roles("USER", "ADMIN").build();
		return userDetails;
	}
	
	@Bean
	public PasswordEncoder passWordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}
}
