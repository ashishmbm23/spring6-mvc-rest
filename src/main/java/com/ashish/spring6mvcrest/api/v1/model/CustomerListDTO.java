package com.ashish.spring6mvcrest.api.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Schema(name = "Customer list model")
public class CustomerListDTO {

    private List<CustomerDTO> customers;
}
