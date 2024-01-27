package com.ashish.spring6mvcrest.service;

import com.ashish.spring6mvcrest.api.v1.model.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> getAllProducts();
    ProductDTO getProductByName(String name);
}
