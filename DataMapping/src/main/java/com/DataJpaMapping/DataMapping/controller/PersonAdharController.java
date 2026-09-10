package com.DataJpaMapping.DataMapping.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DataJpaMapping.DataMapping.Entity.Person;
import com.DataJpaMapping.DataMapping.service.PersonAdharService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/PersonAdhar")
@RequiredArgsConstructor
public class PersonAdharController {
        	
	private final PersonAdharService service;
	
    
	
	@PostMapping("/AddPersonAdhar")
	public Person GeneratePersonAdhar(@RequestBody Person person) {
		return service.AddPersonAdhar(person);
	}
	
	
	
	
	
}
