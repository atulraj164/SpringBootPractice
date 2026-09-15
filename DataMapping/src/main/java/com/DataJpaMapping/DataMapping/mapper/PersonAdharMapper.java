package com.DataJpaMapping.DataMapping.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.web.context.annotation.ApplicationScope;

import com.DataJpaMapping.DataMapping.Dto.AdharRequstDto;
import com.DataJpaMapping.DataMapping.Dto.AdharResponseDto;
import com.DataJpaMapping.DataMapping.Dto.PersonRequestDto;
import com.DataJpaMapping.DataMapping.Dto.PersonResponseDto;
import com.DataJpaMapping.DataMapping.Entity.Adhar;
import com.DataJpaMapping.DataMapping.Entity.Person;

@Mapper(componentModel="spring")
public interface PersonAdharMapper {
	
	 @Mapping(target="adhar", ignore=true)
	 public Person toPerson(PersonRequestDto dto);
	 
	 @Mapping(target="adhar", ignore=true)
	 public PersonResponseDto toPersonResponse (Person person);
	 
	 
     public Adhar toAdhar(AdharRequstDto request);
     
     public AdharResponseDto toAdharResponse(Adhar adhar);
}
