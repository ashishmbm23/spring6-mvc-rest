package com.ashish.spring6mvcrest.api.v1.mapper;

import com.ashish.spring6mvcrest.api.v1.model.VendorDTO;
import com.ashish.spring6mvcrest.domain.Vendor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VendorMapper {

    VendorMapper VENDOR_MAPPER_INSTANCE = Mappers.getMapper(VendorMapper.class);

    VendorDTO convertVendorToVendorDto(Vendor vendor);

    Vendor convertVendorDtoToVendor(VendorDTO vendorDTO);

}
