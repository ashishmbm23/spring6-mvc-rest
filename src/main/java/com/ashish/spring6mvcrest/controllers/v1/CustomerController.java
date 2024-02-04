package com.ashish.spring6mvcrest.controllers.v1;

import com.ashish.spring6mvcrest.api.v1.model.CustomerDTO;
import com.ashish.spring6mvcrest.api.v1.model.CustomerListDTO;
import com.ashish.spring6mvcrest.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CustomerController.BASE_CUSTOMER_URL)
@AllArgsConstructor
@Tag(
        name = "Customer Service",
        description = "CRUD REST APIs for customer"
)
public class CustomerController {
    public static final String BASE_CUSTOMER_URL = "/api/v1/customers";
    private CustomerService customerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Get all customers")
    @ApiResponses(
            @ApiResponse(
                    responseCode = "200",
                    description = "List of customers success response",
                    content =
                        @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = CustomerListDTO.class)
                            )
            )
    )
    public CustomerListDTO getAllCustomers(){
        return new CustomerListDTO( customerService.getAllCustomers() );
    }

//    @GetMapping("/{firstName}")
//    public ResponseEntity<CustomerDTO> getCustomerByFirstName(@PathVariable("firstName") String firstName){
//        return new ResponseEntity<>(customerService.getCustomerByFirstName(firstName), HttpStatus.OK);
//    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Get customer by id")
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "customer by id success response",
                    content =
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CustomerDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "301",
                    description = "customer id not found"
            )}
    )
    public CustomerDTO getCustomerById(@PathVariable("id") Long id){
        return customerService.getCustomerById(id) ;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "create customer")
    @ApiResponses( value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Create customer success response",
                    content =
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = CustomerDTO.class)
                    )
            )}
    )
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
