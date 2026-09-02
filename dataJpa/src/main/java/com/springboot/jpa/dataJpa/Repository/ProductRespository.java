package com.springboot.jpa.dataJpa.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.jpa.dataJpa.Entities.Product;

@Repository
public interface ProductRespository extends JpaRepository<Product,Integer>{
   public List<Product> findByColor(String color);
    public List<Product> deleteByPrice(double price);
}
