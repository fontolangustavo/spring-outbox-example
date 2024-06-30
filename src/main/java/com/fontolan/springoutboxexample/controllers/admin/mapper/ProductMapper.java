package com.fontolan.springoutboxexample.controllers.admin.mapper;

import com.fontolan.springoutboxexample.controllers.admin.request.ProductRequest;
import com.fontolan.springoutboxexample.controllers.admin.response.ProductResponse;
import com.fontolan.springoutboxexample.models.Product;
import org.springframework.stereotype.Component;

@Component("admin.product-mapper")
public class ProductMapper {
    public Product toProduct(ProductRequest request) {
        return Product.builder()
            .name(request.getName())
            .price(request.getPrice())
            .build();
    }

    public ProductResponse toProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getExternalId())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
}
