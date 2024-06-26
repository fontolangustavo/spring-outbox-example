package com.fontolan.springoutboxexample.usecases.impl;

import com.fontolan.springoutboxexample.entities.sqlserver.ProductEntity;
import com.fontolan.springoutboxexample.models.Product;
import com.fontolan.springoutboxexample.repositories.sqlserver.ProductRepository;
import com.fontolan.springoutboxexample.usecases.GetAllProductUseCase;
import com.fontolan.springoutboxexample.usecases.mapper.ProductEntityMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetAllProductUseCaseImpl implements GetAllProductUseCase {
    private final ProductRepository productRepository;
    private final ProductEntityMapper productEntityMapper;

    public GetAllProductUseCaseImpl(
            ProductRepository productRepository,
            ProductEntityMapper productEntityMapper
    ) {
        this.productRepository = productRepository;
        this.productEntityMapper = productEntityMapper;
    }

    @Override
    public Page<Product> getAll() {
        Page<ProductEntity> productEntities = productRepository.findAll(PageRequest.of(0, 10));

        return productEntities.map(productEntityMapper::toProduct);
    }
}
