package com.DataJpaMapping.DataMapping.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.DataJpaMapping.DataMapping.Dto.PersonRequestDto;
import com.DataJpaMapping.DataMapping.Dto.PersonResponseDto;
import com.DataJpaMapping.DataMapping.Entity.Adhar;
import com.DataJpaMapping.DataMapping.Entity.Person;
import com.DataJpaMapping.DataMapping.Repository.AdharRepository;
import com.DataJpaMapping.DataMapping.Repository.PersonRepository;
import com.DataJpaMapping.DataMapping.mapper.PersonAdharMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonAdharService {
   
	   private final PersonRepository personrepository;
       private final PersonAdharMapper mapper;
       
       
	   
	   public PersonResponseDto AddPersonAdhar(PersonRequestDto request) {
		      Person person=new Person();
		      person=mapper.toPerson(request);
		      person.setAdhar(mapper.toAdhar(request.getAdhar()));
		      PersonResponseDto response=new PersonResponseDto();
		      response=mapper.toPersonResponse( personrepository.save(person));
		      response.setAdhar(mapper.toAdharResponse(person.getAdhar()));
		      
		      return response;
	   }
	   
	   public PersonResponseDto getPersonAdharById(int id) {
		   PersonResponseDto response=new PersonResponseDto();
		   Person person= personrepository.findById(id).get();;
		   response=mapper.toPersonResponse(person);
		   response.setAdhar(mapper.toAdharResponse(person.getAdhar()));
		   return response;
	   }
	   
	   public PersonResponseDto getAllPersonAndAdhar(Integer i) {
		   List<Person> person=new ArrayList<>();
		   person=personrepository.findAll(PageRequest.of(5, i)).toList();
		   List<PersonResponseDto>response=
				   person.stream().map(n->mapper.toPersonResponse(n)).toList();
		   
		   response=person.stream().map(n->n.getAdhar()).map(n->mapper.toAdharResponse(n)).toList().to
		   
	   }
	   
	   
	
}
