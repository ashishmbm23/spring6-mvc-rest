package com.ashish.spring6mvcrest.bootstrap;

import com.ashish.spring6mvcrest.domain.Product;
import com.ashish.spring6mvcrest.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Bootstrap implements CommandLineRunner {

    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        saveProducts();
        System.out.println("Total number of products:" + productRepository.count());
    }

    public void saveProducts(){
        Product banana = new Product();
        banana.setName("Banana");

        Product blackberry = new Product();
        blackberry.setName("Blackberry");

        Product cherry = new Product();
        cherry.setName("Cherry");

        Product coconut = new Product();
        coconut.setName("Coconut");

        productRepository.save(banana);
        productRepository.save(blackberry);
        productRepository.save(cherry);
        productRepository.save(coconut);
    }

}
