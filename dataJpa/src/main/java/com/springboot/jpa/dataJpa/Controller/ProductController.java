package com.springboot.jpa.dataJpa.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.dataJpa.Entities.Product;
import com.springboot.jpa.dataJpa.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService service;
	
	
	
	@GetMapping("/test")
	public String get() {
		System.out.println("system working");
		return "system working";
	}
	
	@PostMapping("/RegisterProduct")
	public Product registerProduct(@RequestBody Product product) {
		service.saveProduct(product);
		return product;
	}
	
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		return service.viewAllProducts();
	}
	
	
	
	
}
