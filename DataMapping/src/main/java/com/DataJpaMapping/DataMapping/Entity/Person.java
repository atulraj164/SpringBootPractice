package com.DataJpaMapping.DataMapping.Entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Person {

	private Integer id;
	private String name;
}
