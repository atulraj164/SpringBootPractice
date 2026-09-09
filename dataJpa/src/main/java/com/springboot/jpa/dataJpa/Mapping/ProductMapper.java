package com.springboot.jpa.dataJpa.Mapping;

import java.util.List;

import org.mapstruct.Mapper;

import com.springboot.jpa.dataJpa.Entities.Product;
import com.springboot.jpa.dataJpa.Entities.ProductRequestDto;
import com.springboot.jpa.dataJpa.Entities.ProductResponseDto;

@Mapper(componentModel="spring")
public interface ProductMapper {
          Product toProduct(ProductRequestDto dto);
          ProductResponseDto toProductResponseDto(Product product);
          List<Product> toProduct(List<ProductRequestDto> dto);
          List<ProductResponseDto> toProductResponseDto(List<Product> product);
          
}
