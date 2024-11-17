package com.m2.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImportedProductDTO {
    private Integer prodId;
    private String name;
    private Integer quantity;
    private String quantityUnit;
    private Double price;
}
