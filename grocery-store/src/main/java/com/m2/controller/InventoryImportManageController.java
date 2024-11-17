package com.m2.controller;

import com.m2.dto.ExportedProductDTO;
import com.m2.dto.ImportedProductDTO;
import com.m2.service.InventoryManagedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inventory")
public class InventoryImportManageController {
    private final InventoryManagedService managedService;

    @GetMapping("import")
    public ResponseEntity<?> getAvailableStock(){
        return ResponseEntity.ok(managedService.getAvailableStock());
    }

    @PostMapping("import")
    public ResponseEntity<?> importNewStock(@RequestBody ImportedProductDTO dto){
        return ResponseEntity.ok(managedService.importNewStock(dto));
    }

    @GetMapping("import/{prodId}")
    public ResponseEntity<?> getImportedStock(@PathVariable Integer prodId){
        return ResponseEntity.ok(managedService.getImportStock(prodId));
    }

    @PutMapping("import")
    public ResponseEntity<?> updateStockQuantity(@RequestParam Integer prodId,@RequestParam Integer quantity){
        return ResponseEntity.ok(managedService.updateStockQuantity(prodId,quantity));
    }

    @GetMapping("export")
    public ResponseEntity<?> getExportedStock(){
        return ResponseEntity.ok(managedService.getAllExportProduct());
    }

    @PostMapping("export")
    public ResponseEntity<?> exportStock(@RequestBody ExportedProductDTO dto){
        return ResponseEntity.ok(managedService.exportProduct(dto));
    }
}
