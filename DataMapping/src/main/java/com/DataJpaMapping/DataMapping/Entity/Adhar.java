package com.DataJpaMapping.DataMapping.Entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Adhar {
  private Long id;
  private String fathersName;
}
