package com.ashish.spring6mvcrest.service;

import com.ashish.spring6mvcrest.api.v1.mapper.ProductMapper;
import com.ashish.spring6mvcrest.api.v1.model.ProductDTO;
import com.ashish.spring6mvcrest.domain.Product;
import com.ashish.spring6mvcrest.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Setter
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductMapper productMapper;

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::productToProductDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProductByName(String name) {
        Product product = productRepository.findProductByName(name);
        return productMapper.productToProductDto(product);
    }
}
