package com.m2.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SelectedProductDTO {
    private Integer productId;
    private String name;
    private String description;
    private Double price;
    private String quantity;
    private Integer cartId;
}