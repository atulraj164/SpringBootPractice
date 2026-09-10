package com.DataJpaMapping.DataMapping.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Adhar {
	@Id
  private Long id;
  private String fathersName;
  
  @OneToOne(mappedBy = "adhar")
  private Person person;
}
