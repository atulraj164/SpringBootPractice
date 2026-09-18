package com.SpringSecurity.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class AuthController {
	
		@GetMapping("/getAuth")
		public String getAdmin() {
			return "this is auth";
		}

}
