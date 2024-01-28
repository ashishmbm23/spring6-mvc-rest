package com.ashish.spring6mvcrest.controllers.v1;

import com.ashish.spring6mvcrest.api.v1.model.ProductDTO;
import com.ashish.spring6mvcrest.api.v1.model.ProductListDTO;
import com.ashish.spring6mvcrest.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ProductController.BASE_PRODUCT_URL)
@RequiredArgsConstructor
public class ProductController {

    public static final String BASE_PRODUCT_URL = "/api/v1/products";
    private final ProductService productService;

    @GetMapping()
    public ResponseEntity<ProductListDTO> getAllProducts(){
        return new ResponseEntity<>(new ProductListDTO( productService.getAllProducts() ),
                HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("name") String name){
        return new ResponseEntity<>(productService.getProductByName(name),
                HttpStatus.OK);
    }


}
