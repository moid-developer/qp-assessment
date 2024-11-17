package com.m2.service;

import com.m2.dto.ExportedProductDTO;
import com.m2.dto.ImportedProductDTO;

import java.util.List;

public interface InventoryManagedService {
    String importNewStock(ImportedProductDTO product);
    List<ImportedProductDTO> getAvailableStock();
    ImportedProductDTO getImportStock(Integer prodId);
    String updateStockQuantity(Integer prodId,Integer quantity);
    String exportProduct(ExportedProductDTO productDTO);
    List<ExportedProductDTO> getAllExportProduct();
}
