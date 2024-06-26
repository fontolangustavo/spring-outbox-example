package com.fontolan.springoutboxexample.controllers.partner.mapper;

import com.fontolan.springoutboxexample.controllers.partner.request.ProductRequest;
import com.fontolan.springoutboxexample.controllers.partner.response.ProductResponse;
import com.fontolan.springoutboxexample.models.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toProduct(ProductRequest request) {
        return Product.builder()
            .name(request.getName())
            .price(request.getPrice())
            .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
