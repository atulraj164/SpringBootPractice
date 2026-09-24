package com.SpringSecurity.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.security.Dto.RequestUserRoleDto;
import com.SpringSecurity.security.entity.Role;
import com.SpringSecurity.security.service.RoleService;
import com.SpringSecurity.security.service.UserService;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;


@RestController
@RequestMapping(value="/auth")
@RequiredArgsConstructor
public class AuthController {
	     
	 private final RoleService roleservice;
	 private final UserService userservice;
	  
	  
		@GetMapping("/getAuth")
		public String getAdmin() {
			return "this is auth";
		}
		
		@PostMapping("/saveRole")
		public ResponseEntity<?> addRole(@RequestBody Role role){
			return ResponseEntity.ok(roleservice.saveRole(role));
		}
		
		@PostMapping("/registerUser")
		public ResponseEntity<?> RegisterUser(@RequestBody RequestUserRoleDto role){
			return ResponseEntity.ok(userservice.userRegistration(role));
		}
		
		@GetMapping("/csrf-token")
		
		public CsrfToken getcsrf(HttpServletRequest request) {
			return (CsrfToken) request.getAttribute("_csrf");
		}
		
		
		
		

}
