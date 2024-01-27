package com.ashish.spring6mvcrest.repository;

import com.ashish.spring6mvcrest.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findProductByName(String name);
}
