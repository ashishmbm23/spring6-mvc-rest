package com.ashish.spring6mvcrest.api.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Schema(name = "Product model")
public class ProductDTO {
    private Long id;
    @NotEmpty
    private String name;
}
