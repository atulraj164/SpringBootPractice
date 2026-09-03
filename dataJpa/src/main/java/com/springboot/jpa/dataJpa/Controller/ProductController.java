package com.springboot.jpa.dataJpa.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.dataJpa.Entities.Product;
import com.springboot.jpa.dataJpa.Entities.ProductRequestDto;
import com.springboot.jpa.dataJpa.Entities.ProductResponseDto;
import com.springboot.jpa.dataJpa.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService service;
	
	
	
@GetMapping("/test")
	public ResponseEntity<String> get() {
		return  ResponseEntity
				.status(HttpStatus.OK)
				.body("system Working");
	}
	@GetMapping("/checkException")
	public String checkException() {
		String s=null;
		return  s.trim();
	}
	
	@PostMapping("/RegisterProduct")
	public ProductResponseDto registerProduct(@RequestBody ProductRequestDto ProductRequest) {
		ProductResponseDto response=service.saveProduct(ProductRequest);
		return response ;
	}
	@PostMapping("/RegisterAllProduct")
	public List<ProductResponseDto> registerAllProduct(@RequestBody List<ProductRequestDto> ProductRequest) {
		List<ProductResponseDto> response=service.saveAllProduct(ProductRequest);
		return response;
	}
	
	@GetMapping("/getProductByid/{id}")
	public ProductResponseDto getProductByProduct(@PathVariable int id) {
		ProductResponseDto response=service.getProductById(id);
		return response ;
	}
	
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		return service.viewAllProducts();
	}
	
	@GetMapping("/getProductByColor/{color}")
	public List<ProductResponseDto> getProductByColor(@PathVariable String color) {
		return service.findByColor(color);
	}
	@PostMapping("/deleteByPrice/{price}")
	public List<ProductResponseDto> deleteByPrice(@PathVariable double price) {
		return service.deleteByPrice(price);
	}
	
	
}
