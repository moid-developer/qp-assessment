package com.m2.dto;

import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ExportedProductDTO {
    private Integer prodId;
    private String name;
    private Integer quantity;
    private String quantityUnit;
    private Double price;
    private String duration;
    private String startDate;
    private String endDate;
}
