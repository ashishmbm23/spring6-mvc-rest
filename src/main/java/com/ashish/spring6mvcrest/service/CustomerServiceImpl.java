package com.ashish.spring6mvcrest.service;

import com.ashish.spring6mvcrest.api.v1.mapper.CustomerMapper;
import com.ashish.spring6mvcrest.api.v1.model.CustomerDTO;
import com.ashish.spring6mvcrest.controllers.v1.CustomerController;
import com.ashish.spring6mvcrest.domain.Customer;
import com.ashish.spring6mvcrest.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @Override
    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.findAll()
                .stream()
                .map( customer -> {
                   CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);
                   customerDTO.setCustomerUrl(getCustomerUrl(customerDTO));
                   return customerDTO;
                        })
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO getCustomerByFirstName(String name) {
        return customerMapper.customerToCustomerDTO(customerRepository.findCustomerByFirstName(name));
    }

    @Override
    public CustomerDTO getCustomerById(Long id) {
        return customerMapper.customerToCustomerDTO(customerRepository.findCustomerById(id));
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        CustomerDTO savedCustomerDto = saveAndReturnDto(customer);
        log.info("customer created: " + savedCustomerDto.getId());
        return savedCustomerDto;
    }

    @Override
    public CustomerDTO updateCustomer(Long id, CustomerDTO customerDTO) {
        Customer customer = customerMapper.customerDTOToCustomer(customerDTO);
        customer.setId(id);
        CustomerDTO updatedCustomerDto = saveAndReturnDto(customer);
        log.info("customer updated: " + updatedCustomerDto.getId());
        return updatedCustomerDto;
    }

    @Override
    public CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO) {
        Optional<Customer> savedCustomerOptional = Optional.ofNullable(customerRepository.findById(id).map(customer -> {
            if (customerDTO.getFirstName() != null && !customerDTO.getFirstName().equals("")) {
                customer.setFirstName(customerDTO.getFirstName());
            }
            if (customerDTO.getLastName() != null && !customerDTO.getLastName().equals("")) {
                customer.setLastName(customerDTO.getLastName());
            }
            return customer;
        }).orElseThrow(RuntimeException::new));
        if( savedCustomerOptional.isPresent() ){
            Customer savedCustomer = savedCustomerOptional.get();
            return saveAndReturnDto(savedCustomer);
        }
        return null;
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    private CustomerDTO saveAndReturnDto(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);
        CustomerDTO savedCustomerDto = customerMapper.customerToCustomerDTO(savedCustomer);
        savedCustomerDto.setCustomerUrl(getCustomerUrl(savedCustomerDto));
        return savedCustomerDto;
    }

    private static String getCustomerUrl(CustomerDTO savedCustomerDto) {
        return CustomerController.BASE_CUSTOMER_URL + "/" + savedCustomerDto.getId();
    }
}
