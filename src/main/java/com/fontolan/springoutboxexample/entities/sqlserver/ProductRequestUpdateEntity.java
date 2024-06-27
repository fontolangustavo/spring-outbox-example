package com.fontolan.springoutboxexample.entities.sqlserver;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
