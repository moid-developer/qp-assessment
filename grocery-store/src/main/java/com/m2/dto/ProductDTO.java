package com.m2.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {
    private Integer productId;
    private String name;
    private String description;
    private Double price;
    private String availableQuantity;
}