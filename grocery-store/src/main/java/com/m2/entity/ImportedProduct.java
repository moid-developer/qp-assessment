package com.m2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class ImportedProduct extends BaseEntity{
    @Id
    @GeneratedValue
    private Integer prodId;
    private String name;
    private Integer quantity;
    private String quantityUnit;
    private Double price;
}
