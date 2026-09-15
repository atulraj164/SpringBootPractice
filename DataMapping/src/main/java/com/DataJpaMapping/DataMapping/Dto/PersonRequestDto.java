package com.DataJpaMapping.DataMapping.Dto;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.DataJpaMapping.DataMapping.Entity.Adhar;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequestDto {
	
	    @NotNull
		private Integer id;
	    @NotBlank
		private String name;
	    
		private AdharRequstDto adhar;
}
