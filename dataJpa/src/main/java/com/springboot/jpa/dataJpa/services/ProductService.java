package com.springboot.jpa.dataJpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.dataJpa.Entities.Product;
import com.springboot.jpa.dataJpa.Repository.ProductRespository;

@Service
public class ProductService {
	@Autowired
	ProductRespository pr;
	
	  public Product saveProduct(Product product) {
		  
		  if(product!=null);
		     pr.save(product);
		  
		  return product;
	  }
	public  List<Product> viewAllProducts() {
		List<Product> list=pr.findAll();
		return list;
	  }
}
