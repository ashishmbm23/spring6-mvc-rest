package com.ashish.spring6mvcrest.bootstrap;

import com.ashish.spring6mvcrest.domain.Customer;
import com.ashish.spring6mvcrest.domain.Product;
import com.ashish.spring6mvcrest.repository.CustomerRepository;
import com.ashish.spring6mvcrest.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class Bootstrap implements CommandLineRunner {

    ProductRepository productRepository;
    CustomerRepository customerRepository;

    @Override
    public void run(String... args) throws Exception {
        saveProducts();
        saveCustomers();
        System.out.println("Total number of products:" + productRepository.count());
        log.info("Total number of products: " + productRepository.count());
        log.info("Total number of customers: " + customerRepository.count());
    }

    private void saveCustomers() {
        Customer ashish = new Customer();
        ashish.setFirstName("Ashish");
        ashish.setLastName("Verma");

        Customer harshita = new Customer();
        harshita.setFirstName("Harshita");

        Customer vinod = new Customer();
        vinod.setFirstName("Vinod");
        vinod.setLastName("Kumar Verma");

        customerRepository.save(ashish);
        customerRepository.save(harshita);
        customerRepository.save(vinod);
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
