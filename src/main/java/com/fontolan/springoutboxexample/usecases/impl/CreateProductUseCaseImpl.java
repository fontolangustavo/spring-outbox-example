package com.fontolan.springoutboxexample.usecases.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fontolan.springoutboxexample.enums.ProductRequestUpdateEnum;
import com.fontolan.springoutboxexample.models.Product;
import com.fontolan.springoutboxexample.models.ProductRequestUpdate;
import com.fontolan.springoutboxexample.repositories.sqlserver.ProductRepository;
import com.fontolan.springoutboxexample.repositories.sqlserver.ProductRequestUpdateRepository;
import com.fontolan.springoutboxexample.usecases.CreateProductUseCase;
import com.fontolan.springoutboxexample.usecases.mapper.ProductRequestUpdateEntityMapper;
import org.springframework.stereotype.Component;

@Component
public class CreateProductUseCaseImpl implements CreateProductUseCase {
    private final ProductRequestUpdateRepository productRequestUpdateRepository;
    private final ProductRequestUpdateEntityMapper productRequestUpdateEntityMapper;

    public CreateProductUseCaseImpl(
            ProductRequestUpdateRepository productRequestUpdateRepository,
            ProductRequestUpdateEntityMapper productRequestUpdateEntityMapper
    ) {
        this.productRequestUpdateRepository = productRequestUpdateRepository;
        this.productRequestUpdateEntityMapper = productRequestUpdateEntityMapper;
    }

    @Override
    public Product store(Product product) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        ProductRequestUpdate request = ProductRequestUpdate.builder()
                .oldData(null)
                .newData(mapper.writeValueAsString(product))
                .status(ProductRequestUpdateEnum.WAITING_APPROVE.getStatus())
                .build();

        productRequestUpdateRepository.save(productRequestUpdateEntityMapper.toProductRequestUpdateEntity(request));

        return product;
    }
}
