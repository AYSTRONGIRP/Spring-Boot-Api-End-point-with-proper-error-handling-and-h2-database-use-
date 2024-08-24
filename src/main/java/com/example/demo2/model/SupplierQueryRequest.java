package com.example.demo2.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;

import java.util.List;

public class SupplierQueryRequest {
    @NotBlank(message = "Location is mandatory")
    @Size(max = 100, message = "Location should not exceed 100 characters")
    private String location;

    @NotNull(message = "Nature of business is mandatory")
    @Enumerated(EnumType.STRING)  // Enum is stored as a string in the database
    private NatureOfBusiness natureOfBusiness;

    @NotNull(message = "Manufacturing processes are mandatory")
    @Enumerated(EnumType.STRING)  // Each element in the list is stored as a string in the database
    private ManufacturingProcess manufacturingProcesses;

    @Min(value = 0, message = "Page number cannot be negative")
    private int page = 0;

    @Min(value = 1, message = "Page size must be at least 1")
    @Max(value = 100, message = "Page size cannot exceed 100")
    private int size = 10;

    // Getters and Setters
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public NatureOfBusiness getNatureOfBusiness() {
        return natureOfBusiness;
    }

    public void setNatureOfBusiness(NatureOfBusiness natureOfBusiness) {
        this.natureOfBusiness = natureOfBusiness;
    }

    public ManufacturingProcess getManufacturingProcesses() {
        return manufacturingProcesses;
    }

    public void setManufacturingProcesses(ManufacturingProcess manufacturingProcesses) {
        this.manufacturingProcesses = manufacturingProcesses;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
