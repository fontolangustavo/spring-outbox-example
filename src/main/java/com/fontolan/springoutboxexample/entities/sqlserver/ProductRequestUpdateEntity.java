package com.fontolan.springoutboxexample.entities.sqlserver;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Data
@Builder
@Table(name = "product_request_updates")
public class ProductRequestUpdateEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private ProductEntity product;
    private String oldData;
    private String newData;
    private String status;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
