package com.ashish.spring6mvcrest.service;

import com.ashish.spring6mvcrest.api.v1.model.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO getCustomerByFirstName(String name);
}