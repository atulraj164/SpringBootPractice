package com.springboot.jpa.dataJpa.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductService service;
	
	
	@GetMapping("/checkException")
	public String checkException() {
		String s=null;
		return  s.trim();
	}
	
	@GetMapping("/test")
	public ResponseEntity<String> get() {
		return  ResponseEntity
				.status(HttpStatus.OK)
				.body("system Working");
	}
	
	@PostMapping("/RegisterProduct")
	public ProductResponseDto registerProduct(@Valid @RequestBody ProductRequestDto ProductRequest) {
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
	public List<ProductResponseDto> getAllProducts() {
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
	
	@GetMapping("/getProductByPage/{pageno}")
	public Page<ProductResponseDto> getProductByPage(@PathVariable int pageno){
		return service.pagingProduct(pageno);
	}
	
	
	@GetMapping("/IndexOutOfBoundsExceptionTest")
	public Integer IndexOutOfBoundsExceptionTest() {
		int[] arr=new int[5];
		arr[6]=9;
		return null;
	}
	@GetMapping("/sortProductByattributeAsc/{attribute}")
	public List<ProductResponseDto> sortProductByattributeAsc(@PathVariable String attribute){
		return service.sortProductByattributeAsc(attribute);
	}
	@GetMapping("/sortProductByattributeAsc/{attribute}")
	public List<ProductResponseDto> sortProductByattributeDesc(@PathVariable String attribute){
		return service.sortProductByattributeDesc(attribute);
	}
	@ExceptionHandler(value=IndexOutOfBoundsException.class)//works  only at controller level
	public String outofbondhandler(IndexOutOfBoundsException ex) {
		return ex.getMessage();
	}
	
	
	
	
}
