package com.ashish.spring6mvcrest.controllers.v1;

import com.ashish.spring6mvcrest.api.v1.model.CustomerDTO;
import com.ashish.spring6mvcrest.api.v1.model.CustomerListDTO;
import com.ashish.spring6mvcrest.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<CustomerListDTO> getAllCustomers(){
        return new ResponseEntity<>(new CustomerListDTO( customerService.getAllCustomers() ),
                HttpStatus.OK);
    }

//    @GetMapping("/{firstName}")
//    public ResponseEntity<CustomerDTO> getCustomerByFirstName(@PathVariable("firstName") String firstName){
//        return new ResponseEntity<>(customerService.getCustomerByFirstName(firstName), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable("id") Long id){
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody CustomerDTO customerDTO){
        return new ResponseEntity<CustomerDTO>( customerService.createCustomer(customerDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody CustomerDTO customerDTO,
                                                      @PathVariable("id") Long id){
        return new ResponseEntity<>( customerService.updateCustomer(id, customerDTO) , HttpStatus.CREATED);
    }
}
