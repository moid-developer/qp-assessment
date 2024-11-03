package com.m2.controller;

import com.m2.dto.ProductDTO;
import com.m2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<?> getAllProducts(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO dto){
        return ResponseEntity.ok(productService.saveProduct(dto));
    }

    @PutMapping
    public ResponseEntity<?> updateProductDetails(@RequestBody ProductDTO dto){
        return ResponseEntity.ok(productService.updateProductDetails(dto));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteProducts(@RequestBody List<Integer> ids){
        return ResponseEntity.ok(productService.deleteProduct(ids));
    }
}
