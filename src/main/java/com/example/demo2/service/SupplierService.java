package com.example.demo2.service;

import com.example.demo2.model.ManufacturingProcess;
import com.example.demo2.model.NatureOfBusiness;
import com.example.demo2.model.Supplier;
import com.example.demo2.repo.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;

    public Page<Supplier> findSuppliers(String location, NatureOfBusiness natureOfBusiness,
                                        ManufacturingProcess manufacturingProcess, Pageable pageable) {
        return supplierRepository.findByLocationAndNatureOfBusinessAndManufacturingProcessesContaining(
            location, natureOfBusiness, manufacturingProcess, pageable);
    }
}

