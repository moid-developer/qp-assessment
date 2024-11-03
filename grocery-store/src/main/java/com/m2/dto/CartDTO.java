package com.m2.dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartDTO {
    private Integer cartId;
    private List<SelectedProductDTO> products;
    private Integer userId;
}
