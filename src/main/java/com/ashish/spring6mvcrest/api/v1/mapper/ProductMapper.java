package com.ashish.spring6mvcrest.api.v1.mapper;

import com.ashish.spring6mvcrest.api.v1.model.ProductDTO;
import com.ashish.spring6mvcrest.domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);
    ProductDTO productToProductDto(Product product);
}
