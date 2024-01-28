package com.ashish.spring6mvcrest.repository;

import com.ashish.spring6mvcrest.domain.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
