package com.example.demo2.repo;

import com.example.demo2.model.ManufacturingProcess;
import com.example.demo2.model.NatureOfBusiness;
import com.example.demo2.model.Supplier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("SELECT s FROM Supplier s WHERE " +
            "(:location IS NULL OR s.location LIKE %:location%) AND " +
            "(:natureOfBusiness IS NULL OR s.natureOfBusiness = :natureOfBusiness) AND " +
            "(:manufacturingProcesses IS NULL OR s.manufacturingProcesses = :manufacturingProcesses)")
    Page<Supplier> findByCriteria(
            @Param("location") String location,
            @Param("natureOfBusiness") NatureOfBusiness natureOfBusiness,
            @Param("manufacturingProcesses") ManufacturingProcess manufacturingProcesses,
            Pageable pageable
    );
}
