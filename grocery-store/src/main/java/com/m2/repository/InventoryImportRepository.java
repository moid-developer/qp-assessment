package com.m2.repository;

import com.m2.entity.ImportedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface InventoryImportRepository extends JpaRepository<ImportedProduct,Integer> {
    @Modifying
    @Query(nativeQuery = true,value = "UPDATE IMPORTED_PRODUCT SET QUANTITY=:quantity WHERE PROD_ID=:prodId")
    void updateStockQuantity(int prodId,int quantity);
}
