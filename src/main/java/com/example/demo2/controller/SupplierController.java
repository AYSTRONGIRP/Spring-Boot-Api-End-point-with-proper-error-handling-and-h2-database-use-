package com.example.demo2.controller;

import com.example.demo2.model.ManufacturingProcess;
import com.example.demo2.model.NatureOfBusiness;
import com.example.demo2.model.Supplier;
import com.example.demo2.service.SupplierService;
import com.example.demo2.model.SupplierQueryRequest; // Import the DTO class
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/")
    public String check() {
        return "working";
    }

    @PostMapping("/add")
    public ResponseEntity<Supplier> addSupplier(@RequestBody Supplier supplier) {
        Supplier savedSupplier = supplierService.saveSupplier(supplier);
        return ResponseEntity.ok(savedSupplier);
    }

    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> querySuppliers(@RequestBody SupplierQueryRequest request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        Page<Supplier> suppliers = supplierService.findByCriteria(
                request.getLocation(),
                request.getNatureOfBusiness(),
                request.getManufacturingProcesses(),
                pageable
        );
        return ResponseEntity.ok(suppliers);
    }
}
