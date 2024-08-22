package com.example.demo2.repo;

import com.example.demo2.model.ManufacturingProcess;
import com.example.demo2.model.NatureOfBusiness;
import com.example.demo2.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    Page<Supplier> findByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(
        String location, 
        NatureOfBusiness natureOfBusiness, 
        ManufacturingProcess manufacturingProcess, 
        Pageable pageable);
}

