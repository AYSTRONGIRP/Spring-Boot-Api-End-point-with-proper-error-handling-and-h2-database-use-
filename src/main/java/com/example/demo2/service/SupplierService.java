package com.example.demo2.service;

import com.example.demo2.exception.InvalidEnumValueException;
import com.example.demo2.exception.UniqueConstraintViolationException;
import com.example.demo2.model.ManufacturingProcess;
import com.example.demo2.model.NatureOfBusiness;
import com.example.demo2.model.Supplier;
import com.example.demo2.repo.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    @Transactional
    public Supplier saveSupplier(Supplier supplier) {
        try {
            return supplierRepository.save(supplier);
        } catch (DataIntegrityViolationException e) {
            throw new UniqueConstraintViolationException("Supplier with this website already exists");
        }
    }

    public Page<Supplier> findByCriteria(String location, NatureOfBusiness natureOfBusiness, ManufacturingProcess manufacturingProcesses, Pageable pageable) {
//        validateEnums(natureOfBusiness, manufacturingProcesses);
        return supplierRepository.findByCriteria(location, natureOfBusiness, manufacturingProcesses, pageable);
    }

//    private void validateEnums(Supplier supplier) {
//        validateEnums(supplier.getNatureOfBusiness(), supplier.getManufacturingProcesses());
//    }
//
//    private void validateEnums(NatureOfBusiness natureOfBusiness, ManufacturingProcess manufacturingProcesses) {
//        if (natureOfBusiness == null || manufacturingProcesses == null) {
//            throw new InvalidEnumValueException("Invalid Nature of Business or Manufacturing Process.");
//        }
//    }
}
