package com.ashish.spring6mvcrest.controllers.v1;

import com.ashish.spring6mvcrest.api.v1.model.ProductDTO;
import com.ashish.spring6mvcrest.service.ProductService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    public static final String BANANA = "banana";
    public static final String CHERRY = "cherry";
    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    void getAllProducts() throws Exception {

        List<ProductDTO> productDTOList = new ArrayList<>();
        ProductDTO banana = new ProductDTO();
        banana.setName(BANANA);
        ProductDTO cherry = new ProductDTO();
        cherry.setName(CHERRY);
        productDTOList.add(banana);
        productDTOList.add(cherry);

        when( productService.getAllProducts() ).thenReturn(productDTOList);

        mockMvc.perform(get("/api/v1/products")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.products", Matchers.hasSize(2)));

    }

    @Test
    void getProduct() throws Exception {
        ProductDTO banana = new ProductDTO();
        banana.setName(BANANA);
        when( productService.getProductByName(anyString())).thenReturn(banana);

        mockMvc.perform( get("/api/v1/products/banana")
                .contentType(MediaType.APPLICATION_JSON)
            ).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", Matchers.equalTo(BANANA)));
    }
}