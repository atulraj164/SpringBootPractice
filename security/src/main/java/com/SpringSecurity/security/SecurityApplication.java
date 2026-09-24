package com.SpringSecurity.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class SecurityApplication {

	public static void main(String[] args) { 
		
		ConfigurableApplicationContext ac=SpringApplication.run(SecurityApplication.class, args);
		ConfigurableEnvironment ce=ac.getEnvironment();
		
	
		System.out.println(ce.getProperty("spring.application.name"));
		System.out.println(ce.getProperty("server.port"));
	}

} 
