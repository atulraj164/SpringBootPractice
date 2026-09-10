package com.DataJpaMapping.DataMapping.service;

import org.springframework.stereotype.Service;

import com.DataJpaMapping.DataMapping.Entity.Person;
import com.DataJpaMapping.DataMapping.Repository.AdharRepository;
import com.DataJpaMapping.DataMapping.Repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonAdharService {
   
	   private final PersonRepository personrepository;
	   private final AdharRepository adharrepository;
	   
	   
	   public Person AddPersonAdhar(Person person) {
		   System.out.println(person.getAdhar().getFathersName()+"   "+person.getAdhar().getId());
		   return personrepository.save(person);
	   }
	   
	
}
