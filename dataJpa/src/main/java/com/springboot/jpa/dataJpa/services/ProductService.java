package com.springboot.jpa.dataJpa.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.jpa.dataJpa.Entities.Product;
import com.springboot.jpa.dataJpa.Entities.ProductRequestDto;
import com.springboot.jpa.dataJpa.Entities.ProductResponseDto;
import com.springboot.jpa.dataJpa.ExceptionHandler.BadIdException;
import com.springboot.jpa.dataJpa.Mapping.ProductMapper;
import com.springboot.jpa.dataJpa.Repository.ProductRespository;

@Service
public class ProductService {
	
	final ProductRespository pr;
	final ProductMapper pm;
	
	@Autowired
	public ProductService(ProductRespository pr,ProductMapper pm) {
		this.pm=pm;
		this.pr=pr;
	}
	
	
	  public ProductResponseDto saveProduct(ProductRequestDto request) {
		  Product product=pr.save(pm.toProduct(request));
		  return pm.toProductResponseDto(product);
		  
	  }
	  
	  
	  
public List<ProductResponseDto> saveAllProduct(List<ProductRequestDto> request) {
	
	
	  return pr.saveAll(request.stream()
					    .map(p->pm.toProduct(p))
					    .collect(Collectors.toList())
					    )
			            .stream()
	                    .map(p->pm.toProductResponseDto(p))
	                    .collect(Collectors.toList());
	  }
	  
public ProductResponseDto getProductById(int id) {
	
		  Optional<Product> optional=pr.findById(id);
		  if(optional.isEmpty()) {
			 throw new BadIdException("no such Id Exists");
		  }
		  Product product=optional.get();  
		  return pm.toProductResponseDto(product);
		  
	  }
	  
	  
@Transactional
public List<ProductResponseDto> deleteByPrice(double id) {
		return  pr.deleteByPrice(id).stream()
				.map(p->pm.toProductResponseDto(p))
				.collect(Collectors.toList());
	  }
	  
	  
public List<ProductResponseDto> findByColor(String color){
		
		return  pr.findByColor(color)
				 .stream()
				.map(p->pm.toProductResponseDto(p))
				.collect(Collectors.toList());	  
	  }

public  List<ProductResponseDto> viewAllProducts() {
	
	  return pr.findAll()
			  .stream()
			  .map(p->pm.toProductResponseDto(p))
			  .collect(Collectors.toList());
		 
	  }

public Page<ProductResponseDto> pagingProduct(int pageno){
	Page<Product> page=pr.findAll(PageRequest.of(pageno, 5));
	return page.map(p->pm.toProductResponseDto(p));	
}

public List<ProductResponseDto> sortProductByattributeAsc(String attribute){
	return pr.findAll(Sort.by(Order.asc(attribute)))
			.stream().map(p->pm.toProductResponseDto(p)).toList();
}
public List<ProductResponseDto> sortProductByattributeDesc(String attribute){
	return pr.findAll(Sort.by(Order.desc(attribute)))
			.stream().map(p->pm.toProductResponseDto(p)).toList();
}



  

}

  


  

}
