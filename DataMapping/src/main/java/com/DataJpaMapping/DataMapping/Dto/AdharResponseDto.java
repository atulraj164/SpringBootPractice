package com.DataJpaMapping.DataMapping.Dto;

import com.DataJpaMapping.DataMapping.Entity.Adhar;
import com.DataJpaMapping.DataMapping.Entity.Person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdharResponseDto {
	private Long id;
    private String fathersName;
    private Person person;
}
