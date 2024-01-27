package com.ashish.spring6mvcrest.service;

import com.ashish.spring6mvcrest.api.v1.mapper.CustomerMapper;
import com.ashish.spring6mvcrest.api.v1.model.CustomerDTO;
import com.ashish.spring6mvcrest.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::customerToCustomerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerByFirstName(String name) {
        return customerMapper.customerToCustomerDTO(customerRepository.findCustomerByFirstName(name));
    }
}
