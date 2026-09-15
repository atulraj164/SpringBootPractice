package com.DataJpaMapping.DataMapping.Dto;

import com.DataJpaMapping.DataMapping.Entity.Adhar;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonResponseDto {
			private Integer id;
			private String name;
            private AdharResponseDto adhar;
}
