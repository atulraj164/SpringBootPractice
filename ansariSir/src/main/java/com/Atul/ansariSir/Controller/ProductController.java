package com.Atul.ansariSir.Controller;

import java.util.List;
import java.util.stream.Collector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import crudDto.ProductRequestDTO;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @GetMapping("/GetProductById")
    public String getProductById() {
        return "this is my first product";
    }

    @GetMapping("/AddTwoNumbers/{a}/{b}")
    public Integer addTwoNumbers(@PathVariable Integer a,
                                 @PathVariable Integer b) {
        return a + b;
    }

    @GetMapping("/MulTwoNumbers")
    public Integer mulTwoNumbers(@RequestParam Integer a,
                                 @RequestParam Integer b) {
        return a * b;
    }
    
    @PostMapping("/registerProduct")
    public ProductRequestDTO registerProduct(@RequestBody ProductRequestDTO dto) {
    	System.out.println(dto.getId());
    	
		return dto;
    	
    }
    @PostMapping("/registerAllProduct")
    public List<ProductRequestDTO> registerProduct(@RequestBody List<ProductRequestDTO> dto) {
    	
    	return dto.stream().filter(n->n.getPrice()<30).toList();
    	

		
  
    }
}
