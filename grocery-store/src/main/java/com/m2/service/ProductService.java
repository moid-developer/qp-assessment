package com.m2.service;

import com.m2.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAllProduct();
    String saveProduct(ProductDTO dto);
    String deleteProduct(List<Integer> ids);
    String updateProductDetails(ProductDTO dto);
}
