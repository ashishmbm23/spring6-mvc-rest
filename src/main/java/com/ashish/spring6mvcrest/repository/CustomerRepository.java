package com.ashish.spring6mvcrest.repository;

import com.ashish.spring6mvcrest.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findCustomerByFirstName(String name);
    Customer findCustomerById(Long id);
}
