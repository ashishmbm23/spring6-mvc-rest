package com.ashish.spring6mvcrest.service;

import com.ashish.spring6mvcrest.api.v1.mapper.VendorMapper;
import com.ashish.spring6mvcrest.api.v1.model.VendorDTO;
import com.ashish.spring6mvcrest.controllers.v1.VendorController;
import com.ashish.spring6mvcrest.domain.Vendor;
import com.ashish.spring6mvcrest.repository.VendorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class VendorServiceImpl implements VendorService {

    VendorRepository vendorRepository;
    VendorMapper vendorMapper;

    @Override
    public List<VendorDTO> getAllVendors() {
        return vendorRepository.findAll()
                .stream()
                .map(vendor -> {
                   VendorDTO vendorDTO = vendorMapper.convertVendorToVendorDto(vendor);
                   vendorDTO.setVendorUrl(getVendorUrl(vendorDTO.getId()));
                   return vendorDTO;
                } )
                .collect(Collectors.toList());
    }

    @Override
    public VendorDTO getVendorById(Long id) {
        return vendorRepository.findById(id).
                map(vendor -> {
                    VendorDTO vendorDTO = vendorMapper.convertVendorToVendorDto(vendor);
                    vendorDTO.setVendorUrl(getVendorUrl(id));
                    return vendorDTO;
                }).get();
    }

    @Override
    public VendorDTO createVendor(VendorDTO vendorDTO) {
        Vendor vendor = vendorMapper.convertVendorDtoToVendor(vendorDTO);
        return saveAndReturnVendorDTO(vendor);
    }

    private VendorDTO saveAndReturnVendorDTO(Vendor vendor) {
        Vendor savedVendor = vendorRepository.save(vendor);
        VendorDTO savedVendorDTO = vendorMapper.convertVendorToVendorDto(savedVendor);
        savedVendorDTO.setVendorUrl(getVendorUrl(savedVendorDTO.getId()));
        return savedVendorDTO;
    }

    @Override
    public VendorDTO updateVendor(VendorDTO vendorDTO, Long id) {
        Vendor vendor = vendorMapper.convertVendorDtoToVendor(vendorDTO);
        vendor.setId(id);
        return saveAndReturnVendorDTO(vendor);
    }

    @Override
    public VendorDTO patchVendor(VendorDTO vendorDTO, Long id) {
        Vendor vendor = vendorRepository.findById(id).get();
        if( vendorDTO != null ){
            if( vendorDTO.getName() != null && !vendorDTO.getName().equals("")){
                vendor.setName(vendorDTO.getName());
            }
        }
        return saveAndReturnVendorDTO(vendor);
    }

    @Override
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }

    private String getVendorUrl(Long id){
        return VendorController.VENDOR_BASE_URL + "/" + id ;
    }
}
