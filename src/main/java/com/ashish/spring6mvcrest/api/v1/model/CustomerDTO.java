package com.ashish.spring6mvcrest.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(name = "Customer model")
public class CustomerDTO {
    @Schema(
            description = "Customer id"
    )
    private Long id;
    @Schema( description = "First Name")
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @JsonProperty("customer_url")
    private String customerUrl;
}
