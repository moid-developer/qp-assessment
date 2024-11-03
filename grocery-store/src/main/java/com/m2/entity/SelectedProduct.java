package com.m2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SelectedProduct {
    @Id
    @GeneratedValue
    private Integer productId;
    private String name;
    private String description;
    private Double price;
    private String quantity;
    private Integer cartId;
}