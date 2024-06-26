package com.fontolan.springoutboxexample.usecases.mapper;

import com.fontolan.springoutboxexample.entities.sqlserver.ProductEntity;
import com.fontolan.springoutboxexample.models.Product;

public class ProductEntityMapper {
    public Product toProduct(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .externalId(productEntity.getExternalId())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .build();
    }

    public ProductEntity toProductEntity(Product product) {
        return ProductEntity.builder()
                .id(product.getId())
                .externalId(product.getExternalId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}