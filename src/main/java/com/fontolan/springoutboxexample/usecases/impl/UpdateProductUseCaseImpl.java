package com.fontolan.springoutboxexample.usecases.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fontolan.springoutboxexample.entities.sqlserver.ProductEntity;
import com.fontolan.springoutboxexample.enums.ProductRequestUpdateEnum;
import com.fontolan.springoutboxexample.models.Product;
import com.fontolan.springoutboxexample.models.ProductRequestUpdate;
import com.fontolan.springoutboxexample.repositories.sqlserver.ProductRepository;
import com.fontolan.springoutboxexample.repositories.sqlserver.ProductRequestUpdateRepository;
import com.fontolan.springoutboxexample.usecases.UpdateProductUseCase;
import com.fontolan.springoutboxexample.usecases.mapper.sqlserver.ProductRequestUpdateEntityMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateProductUseCaseImpl implements UpdateProductUseCase {
    private final ProductRepository productRepository;
    private final ProductRequestUpdateRepository productRequestUpdateRepository;
    private final ProductRequestUpdateEntityMapper productRequestUpdateEntityMapper;

    public UpdateProductUseCaseImpl(
        ProductRepository productRepository,
        ProductRequestUpdateRepository productRequestUpdateRepository,
        ProductRequestUpdateEntityMapper productRequestUpdateEntityMapper
    ) {
        this.productRepository = productRepository;
        this.productRequestUpdateRepository = productRequestUpdateRepository;
        this.productRequestUpdateEntityMapper = productRequestUpdateEntityMapper;
    }

    @Override
    public void update(Product product) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Optional<ProductEntity> optionalProductEntity = productRepository.findByExternalId(product.getExternalId());

        if (optionalProductEntity.isEmpty()) {
            throw new RuntimeException("not found");
        }

        product.setId(String.valueOf(optionalProductEntity.get().getId()));

        ProductEntity oldProductEntity = new ProductEntity();
        BeanUtils.copyProperties(optionalProductEntity.get(), oldProductEntity);
        ProductEntity newProductEntity = new ProductEntity();
        BeanUtils.copyProperties(optionalProductEntity.get(), newProductEntity);

        newProductEntity.setName(product.getName());
        newProductEntity.setPrice(product.getPrice());

        ProductRequestUpdate request = ProductRequestUpdate.builder()
                .product(product)
                .oldData(mapper.writeValueAsString(oldProductEntity))
                .newData(mapper.writeValueAsString(newProductEntity))
                .status(ProductRequestUpdateEnum.WAITING_APPROVE.getStatus())
                .build();

        productRequestUpdateRepository.save(
                productRequestUpdateEntityMapper.toProductRequestUpdateEntity(request)
        );
    }
}
