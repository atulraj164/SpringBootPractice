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
	
	  public ProductResponseDto saveProduct(ProductRequestDto RequestDto) {
		  
		Product product=new Product();
		product.setColor(RequestDto.getColor());
		product.setId(RequestDto.getId());
		product.setName(RequestDto.getName());
		product.setPrice(RequestDto.getPrice());
		product.setQuantity(RequestDto.getQuantity());
		
		pr.save(product);
		
		
		 ProductResponseDto ResponseDto=new ProductResponseDto();
		 ResponseDto.setColor(product.getColor());
		 ResponseDto.setName(product.getName());
		 ResponseDto.setId(product.getId());
		 ResponseDto.setPrice(product.getPrice());
		 ResponseDto.setQuantity(product.getQuantity());
		return ResponseDto;
	  }
	  
	  
	  public List<ProductResponseDto> saveAllProduct(List<ProductRequestDto> RequestDto) {
		  List<Product> products=new ArrayList<>();
		   for (ProductRequestDto request : RequestDto) {
			  Product product=new Product();
			   product.setColor(request.getColor());
				product.setId(request.getId());
				product.setName(request.getName());
				product.setPrice(request.getPrice());
				product.setQuantity(request.getQuantity());
				products.add(product);	
		}
		   pr.saveAll(products);
		   
		   List<ProductResponseDto> ResponseDto=new ArrayList<>();
		   for(Product product:products) {
			   
		   ProductResponseDto ResponseDtos=new ProductResponseDto();
		   
			 ResponseDtos.setColor(product.getColor());
			 ResponseDtos.setName(product.getName());
			 ResponseDtos.setId(product.getId());
			 ResponseDtos.setPrice(product.getPrice());
			 ResponseDtos.setQuantity(product.getQuantity());
			 ResponseDto.add(ResponseDtos);
		   }
		   return ResponseDto;
		   
		   
		  
	  }
	  
	  public ProductResponseDto getProductById(int id) {
		  Optional<Product> optional=pr.findById(id);
		  Product product=optional.get();
		  
		  ProductResponseDto responseDto=new ProductResponseDto();
		  responseDto.setId(product.getId());
		  responseDto.setColor(product.getColor());
		  responseDto.setName(product.getName());
		  responseDto.setPrice(product.getPrice());
		  responseDto.setQuantity(product.getQuantity());
		  return responseDto;
		  
	  }
	  
public  List<Product> viewAllProducts() {
		List<Product> list=pr.findAll();
		return list;
	  }

}
