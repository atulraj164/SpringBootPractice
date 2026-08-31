package com.springboot.jpa.dataJpa.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Product {
	@Id
    private int id;
    private String name;
    private String color;
    private double price;
}
