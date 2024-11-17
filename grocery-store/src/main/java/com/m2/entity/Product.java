package com.m2.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue
    private Integer productId;
    private String name;
    private String description;
    private String availableQuantity;
    private Double purchaseRate;
    private Double sellingRate;
}
