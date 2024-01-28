package com.ashish.spring6mvcrest.service;

import com.ashish.spring6mvcrest.api.v1.model.VendorDTO;

import java.util.List;

public interface VendorService {
    List<VendorDTO> getAllVendors();

    VendorDTO getVendorById(Long id);

    VendorDTO createVendor(VendorDTO vendorDTO);

    VendorDTO updateVendor( VendorDTO vendorDTO, Long id);

    VendorDTO patchVendor( VendorDTO vendorDTO, Long id);

    void deleteVendor(Long id);
}
