package com.m2.entity;

import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String lastUpdatedBy;
    @CreatedDate
    private LocalDateTime createdTimestamp;
    @LastModifiedDate
    private LocalDateTime lastUpdatedTimestamp;
}
