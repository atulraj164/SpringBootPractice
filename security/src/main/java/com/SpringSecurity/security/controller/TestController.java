package com.SpringSecurity.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
      
	@GetMapping("/TestSecurity")
	
	public String TestSecurity() {
		return "security tested";
	}
}
