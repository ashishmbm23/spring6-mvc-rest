package com.ashish.spring6mvcrest.api.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Schema(name = "Vendor model")
public class VendorListDTO {
    private List<VendorDTO> vendors;
}
