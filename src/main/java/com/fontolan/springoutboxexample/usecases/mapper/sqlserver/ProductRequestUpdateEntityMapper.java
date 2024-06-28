package com.fontolan.springoutboxexample.usecases.mapper.sqlserver;

import com.fontolan.springoutboxexample.entities.sqlserver.ProductEntity;
import com.fontolan.springoutboxexample.entities.sqlserver.ProductRequestUpdateEntity;
import com.fontolan.springoutboxexample.models.Product;
import com.fontolan.springoutboxexample.models.ProductRequestUpdate;
import org.springframework.stereotype.Component;

@Component
public class ProductRequestUpdateEntityMapper {
    public ProductRequestUpdate toProductRequestUpdate(ProductRequestUpdateEntity requestUpdate) {
        ProductRequestUpdate productRequestUpdate = ProductRequestUpdate.builder()
                .id(requestUpdate.getId())
                .oldData(requestUpdate.getOldData())
                .newData(requestUpdate.getNewData())
                .status(requestUpdate.getStatus())
                .build();

        if (requestUpdate.getProduct() != null) {
            productRequestUpdate.setProduct(
                Product.builder()
                    .id(requestUpdate.getProduct().getId())
                    .externalId(requestUpdate.getProduct().getExternalId())
                    .name(requestUpdate.getProduct().getName())
                    .price(requestUpdate.getProduct().getPrice())
                    .build()
            );
        }

        return productRequestUpdate;
    }

    public ProductRequestUpdateEntity toProductRequestUpdateEntity(ProductRequestUpdate requestUpdate) {
        ProductRequestUpdateEntity productRequestUpdate = ProductRequestUpdateEntity.builder()
                .id(requestUpdate.getId())
                .oldData(requestUpdate.getOldData())
                .newData(requestUpdate.getNewData())
                .status(requestUpdate.getStatus())
                .build();

        if (requestUpdate.getProduct() != null) {
            productRequestUpdate.setProduct(
                ProductEntity.builder()
                    .id(requestUpdate.getProduct().getId())
                    .externalId(requestUpdate.getProduct().getExternalId())
                    .name(requestUpdate.getProduct().getName())
                    .price(requestUpdate.getProduct().getPrice())
                    .build()
            );
        }

        return productRequestUpdate;
    }
}
