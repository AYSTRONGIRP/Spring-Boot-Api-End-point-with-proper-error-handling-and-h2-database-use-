package com.example.demo2.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;

    private String companyName;
    private String website;
    private String location;

    @Enumerated(EnumType.STRING)  // Enum is stored as a string in the database
    private NatureOfBusiness natureOfBusiness;

    @ElementCollection
    @Enumerated(EnumType.STRING)  // Each element in the list is stored as a string in the database
    private List<ManufacturingProcess> manufacturingProcesses;

    // Getters and Setters
    
}
