package com.fontolan.springoutboxexample.entities.mongodb;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.ZonedDateTime;

@Data
@Document(collection = "products")
public class ProductEntity {
    @Id
    private Long id;
    private String externalId;
    private String name;
    private double price;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private ZonedDateTime deletedAt;
}
