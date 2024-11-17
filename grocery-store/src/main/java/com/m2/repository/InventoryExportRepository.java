package com.m2.repository;

import com.m2.entity.ExportedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryExportRepository extends JpaRepository<ExportedProduct,Integer> {
}
