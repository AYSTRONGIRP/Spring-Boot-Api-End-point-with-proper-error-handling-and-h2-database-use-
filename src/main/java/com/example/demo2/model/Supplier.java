package com.example.demo2.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "supplier", uniqueConstraints = @UniqueConstraint(columnNames = "website"))
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long supplierId;

    @NotBlank(message = "Company name is mandatory")
    @Size(max = 100, message = "Company name should not exceed 100 characters")
    private String companyName;

    @NotBlank(message = "Website is mandatory")
    @Pattern(regexp = "^(http|https)://.*$", message = "Website must be a valid URL")
    private String website;

    @NotBlank(message = "Location is mandatory")
    @Size(max = 100, message = "Location should not exceed 100 characters")
    private String location;

    @NotNull(message = "Nature of business is mandatory")
    @Enumerated(EnumType.STRING)  // Enum is stored as a string in the database
    private NatureOfBusiness natureOfBusiness;

    @NotNull(message = "Manufacturing processes are mandatory")
    @Enumerated(EnumType.STRING)  // Each element in the list is stored as a string in the database
    private ManufacturingProcess manufacturingProcesses;

    // Getters and Setters
    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

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
}
