package com.DataJpaMapping.DataMapping.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Person {
     
     @Id	
	private Integer id;
	private String name;
	
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="adhar")
	private Adhar adhar;
}
