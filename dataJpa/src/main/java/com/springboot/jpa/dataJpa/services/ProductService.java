package com.springboot.jpa.dataJpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.springboot.jpa.dataJpa.Entities.Product;
import com.springboot.jpa.dataJpa.Entities.ProductRequestDto;
import com.springboot.jpa.dataJpa.Entities.ProductResponseDto;
import com.springboot.jpa.dataJpa.Repository.ProductRespository;

@Service
public class ProductService {
	@Autowired
	ProductRespository pr;
	
	  public ProductResponseDto saveProduct(ProductRequestDto request) {
		  Product product=pr.save(new Product(request));
		  return new ProductResponseDto(product);
	  }
	  
public List<ProductResponseDto> saveAllProduct(List<ProductRequestDto> request) {
  return pr.saveAll(request.stream()
					    .map(p->new Product(p))
					    .collect(Collectors.toList()))
			            .stream()
	                    .map(p->new ProductResponseDto(p))
	                    .collect(Collectors.toList());
	  }
	  	  
public ProductResponseDto getProductById(int id) {
	
		  Optional<Product> optional=pr.findById(id);
		  if(optional.isEmpty()) {
			 throw new BadIdException("no such Id Exists");
		  }
		  Product product=optional.get();  
		  return new ProductResponseDto(product);
		  
	  }
	  
	
@Transactional
public List<ProductResponseDto> deleteByPrice(double id) {
		return  pr.deleteByPrice(id).stream()
				.map(p->new ProductResponseDto(p))
				.collect(Collectors.toList());
	  }
	  
	
	  
public List<ProductResponseDto> findByColor(String color){
		
		return  pr.findByColor(color)
				 .stream()
				.map(p->new ProductResponseDto(p))
				.collect(Collectors.toList());	  
	  }
	  


public  List<ProductResponseDto> viewAllProducts() {
	
	  return pr.findAll()
			  .stream()
			  .map(p->new ProductResponseDto(p))
			  .collect(Collectors.toList());
		 
	  }

  


  

}
