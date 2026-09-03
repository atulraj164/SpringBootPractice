package com.springboot.jpa.dataJpa.Entities;

import lombok.Data;



@Data
public class ProductResponseDto {

	    private int id;
	    private String name;
	    private String color;
	    private double price;
	    private double quantity;

	    public ProductResponseDto(Product product) {
	    	this.id=product.getId();
	    	this.name=product.getName();
	    	this.price=product.getPrice();
	    	this.color=product.getColor();
	    	this.quantity=product.getQuantity();
	    }

		public ProductResponseDto() {
			
		}

}
