package com.fontolan.springoutboxexample.usecases.mapper.mongodb;

import com.fontolan.springoutboxexample.entities.mongodb.ProductEntity;
import com.fontolan.springoutboxexample.models.Product;
import org.springframework.stereotype.Component;

@Component("mongodb-product-mapper")
public class ProductEntityMapper {
    public Product toProduct(ProductEntity productEntity) {
        return Product.builder()
                .id(productEntity.getId())
                .externalId(productEntity.getExternalId())
                .name(productEntity.getName())
                .price(productEntity.getPrice())
                .build();
    }
}
