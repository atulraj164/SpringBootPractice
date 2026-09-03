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
	 List<Product> products=pr.saveAll(request.stream()
					    .map(p->new Product(p))
					    .collect(Collectors.toList()));
		   
                  return  products.stream()
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
	
		List<Product> products= pr.deleteByPrice(id);
		List<ProductResponseDto> ResponseDto=new ArrayList<>();
		  for(Product product:products) {	   
			    ProductResponseDto ResponseDtos=new ProductResponseDto(product);
				 ResponseDto.add(ResponseDtos);
			   }
			   return ResponseDto;
	  }
	
	
public List<ProductResponseDto> findByColor(String color){
		  List<Product> products=pr.findByColor(color);
		  List<ProductResponseDto> ResponseDto=new ArrayList<>();
		  
		   for(Product product:products) {
			   
		   ProductResponseDto ResponseDtos=new ProductResponseDto(product);
			 ResponseDto.add(ResponseDtos);
		   }
		return ResponseDto;
		  
	  }
	  

	  

public  List<ProductResponseDto> viewAllProducts() {
	
		List<Product> products=pr.findAll();
		
	    List<ProductResponseDto> ResponseDto=new ArrayList<>();
		 
		   for(Product product:products) {
			   
		     ProductResponseDto ResponseDtos=new ProductResponseDto(product);
			 ResponseDto.add(ResponseDtos);
		   }
		return ResponseDto;
	  }

  

}
