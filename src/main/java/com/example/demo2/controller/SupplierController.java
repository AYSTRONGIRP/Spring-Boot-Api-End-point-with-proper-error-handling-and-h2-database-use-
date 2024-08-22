package com.example.demo2.controller;

import com.example.demo2.model.ManufacturingProcess;
import com.example.demo2.model.NatureOfBusiness;
import com.example.demo2.model.Supplier;
import com.example.demo2.service.SupplierService;
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
    public String check(){
        System.out.println("working");
        return "wokring";
    }

//    @PostMapping("/add")

    @PostMapping("/query")
    public ResponseEntity<Page<Supplier>> querySuppliers(
            @RequestParam String location,
            @RequestParam NatureOfBusiness natureOfBusiness,
            @RequestParam ManufacturingProcess manufacturingProcess,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Supplier> suppliers = supplierService.findSuppliers(location, natureOfBusiness, manufacturingProcess, pageable);

        return ResponseEntity.ok(suppliers);
    }
}

