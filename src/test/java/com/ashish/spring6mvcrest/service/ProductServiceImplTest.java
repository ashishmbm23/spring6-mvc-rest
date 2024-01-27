package com.ashish.spring6mvcrest.service;

import com.ashish.spring6mvcrest.api.v1.mapper.ProductMapper;
import com.ashish.spring6mvcrest.api.v1.model.ProductDTO;
import com.ashish.spring6mvcrest.domain.Product;
import com.ashish.spring6mvcrest.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
class ProductServiceImplTest {

    public static final String BANANA = "banana";
    @Mock
    private ProductRepository productRepository;
    private ProductMapper productMapper = ProductMapper.PRODUCT_MAPPER;
    @InjectMocks
    ProductServiceImpl productService;
    @BeforeEach
    void setUp() {
        productService.setProductMapper(productMapper);
    }

    @Test
    void getAllProducts() {
        List<Product> products = new ArrayList<>();
        Product banana = getProduct();
        products.add(banana);
        Mockito.when(productRepository.findAll()).thenReturn(products);
        List<ProductDTO> productDTOS = productService.getAllProducts();
        assertNotNull(productDTOS);
        assertEquals(1, productDTOS.size());
    }


    @Test
    void getProductByName() {
        Product banana = getProduct();
        Mockito.when(productRepository.findProductByName(Mockito.anyString())).thenReturn(banana);

        ProductDTO bananaDto = productService.getProductByName("banana");
        assertNotNull(bananaDto);
        assertEquals(BANANA, bananaDto.getName());
    }

    private static Product getProduct() {
        Product banana = new Product();
        banana.setName(BANANA);
        return banana;
    }
}