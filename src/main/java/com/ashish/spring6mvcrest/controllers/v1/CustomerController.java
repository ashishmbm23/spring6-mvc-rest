package com.ashish.spring6mvcrest.controllers.v1;

import com.ashish.spring6mvcrest.api.v1.model.CustomerDTO;
import com.ashish.spring6mvcrest.api.v1.model.CustomerListDTO;
import com.ashish.spring6mvcrest.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CustomerController.BASE_CUSTOMER_URL)
@AllArgsConstructor
public class CustomerController {
    public static final String BASE_CUSTOMER_URL = "/api/v1/customers";
    private CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDTO getAllCustomers(){
        return new CustomerListDTO( customerService.getAllCustomers() );
    }

//    @GetMapping("/{firstName}")
//    public ResponseEntity<CustomerDTO> getCustomerByFirstName(@PathVariable("firstName") String firstName){
//        return new ResponseEntity<>(customerService.getCustomerByFirstName(firstName), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO getCustomerById(@PathVariable("id") Long id){
        return customerService.getCustomerById(id) ;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createCustomer(@RequestBody CustomerDTO customerDTO){
        return customerService.createCustomer(customerDTO);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO updateCustomer(@RequestBody CustomerDTO customerDTO,
                                                      @PathVariable("id") Long id){
        return customerService.updateCustomer(id, customerDTO) ;
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO patchCustomer(@RequestBody CustomerDTO customerDTO,
                                                      @PathVariable("id") Long id){
        return customerService.patchCustomer(id, customerDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable("id") Long id){
       customerService.deleteCustomerById(id);
    }
}
