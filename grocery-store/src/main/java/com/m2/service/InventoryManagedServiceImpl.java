package com.m2.service;

import com.m2.dto.ExportedProductDTO;
import com.m2.dto.ImportedProductDTO;
import com.m2.entity.ExportedProduct;
import com.m2.entity.ImportedProduct;
import com.m2.repository.InventoryExportRepository;
import com.m2.repository.InventoryImportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InventoryManagedServiceImpl implements InventoryManagedService {
    private final InventoryImportRepository importRepository;

    private final InventoryExportRepository exportRepository;
    /**
     * @param product
     * @return
     */
    @Override
    public String importNewStock(ImportedProductDTO product) {
        ImportedProduct importedProduct=importRepository.save(convertDTO(product));
        return Objects.nonNull(importedProduct)?"Stock added":"Stock not added";
    }
    private ImportedProduct convertDTO(ImportedProductDTO dto){
        return ImportedProduct.builder()
                .name(dto.getName())
                .price(dto.getPrice())
                .quantityUnit(dto.getQuantityUnit())
                .quantity(dto.getQuantity())
                .price(dto.getPrice())
                .build();
    }

    /**
     * @return
     */
    @Override
    public List<ImportedProductDTO> getAvailableStock() {
        List<ImportedProduct> entities=importRepository.findAll();
        return entities.stream().map(e->convertEntity(e)).toList();
    }
    private ImportedProductDTO  convertEntity(ImportedProduct product){
        return ImportedProductDTO .builder()
                .prodId(product.getProdId())
                .name(product.getName())
                .price(product.getPrice())
                .quantityUnit(product.getQuantityUnit())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .build();
    }
    /**
     * @param prodId
     * @return
     */
    @Override
    public ImportedProductDTO getImportStock(Integer prodId) {
        ImportedProduct product=importRepository.findById(prodId).orElseThrow(()-> new RuntimeException("Product not found"));
        return convertEntity(product);
    }

    /**
     * @param prodId
     * @param quantity
     * @return
     */
    @Transactional
    @Override
    public String updateStockQuantity(Integer prodId, Integer quantity) {
        importRepository.updateStockQuantity(prodId,quantity);
        return "Stock quantity updated successfully";
    }

    /**
     * @param productDTO
     * @return
     */
    @Override
    public String exportProduct(ExportedProductDTO productDTO) {
        ExportedProduct product=exportRepository.save(convertDTO(productDTO));
        return "Product Exported";
    }

    /**
     * @return
     */
    @Override
    public List<ExportedProductDTO> getAllExportProduct() {
        List<ExportedProductDTO> dtos=exportRepository.findAll().stream().map(e->convertEntity(e)).toList();
        return dtos;
    }

    private ExportedProduct convertDTO(ExportedProductDTO dto){
        return ExportedProduct.builder()
                .name(dto.getName())
                .duration(dto.getDuration())
                .price(dto.getPrice())
                .quantityUnit(dto.getQuantityUnit())
                .quantity(dto.getQuantity())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();
    }
    private ExportedProductDTO convertEntity(ExportedProduct dto){
        return ExportedProductDTO.builder()
                .prodId(dto.getProdId())
                .name(dto.getName())
                .duration(dto.getDuration())
                .price(dto.getPrice())
                .quantityUnit(dto.getQuantityUnit())
                .quantity(dto.getQuantity())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .build();
    }
}
