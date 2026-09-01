package com.springboot.jpa.dataJpa.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;



@Data
public class ProductRequestDto{
	    private int id;
	    private String name;
	    private String color;
	    private double price;
	    private double quantity;
	}


