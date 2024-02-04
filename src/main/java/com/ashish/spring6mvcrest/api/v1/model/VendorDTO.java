package com.ashish.spring6mvcrest.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@Schema(name = "Vendor model")
public class VendorDTO {
    private Long id;
    @NotEmpty
    private String name;
    @JsonProperty("vendor_url")
    private String vendorUrl;
}
