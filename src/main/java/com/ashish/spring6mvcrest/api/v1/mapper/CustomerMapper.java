package com.ashish.spring6mvcrest.api.v1.mapper;

import com.ashish.spring6mvcrest.api.v1.model.CustomerDTO;
import com.ashish.spring6mvcrest.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper CUSTOMER_MAPPER = Mappers.getMapper(CustomerMapper.class);

    public CustomerDTO customerToCustomerDTO(Customer customer);
}
