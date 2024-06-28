package com.fontolan.springoutboxexample.usecases.impl.sqlserver;

import com.fontolan.springoutboxexample.entities.sqlserver.ProductEntity;
import com.fontolan.springoutboxexample.models.Product;
import com.fontolan.springoutboxexample.repositories.sqlserver.ProductRepository;
import com.fontolan.springoutboxexample.usecases.GetAllProductUseCase;
import com.fontolan.springoutboxexample.usecases.mapper.sqlserver.ProductEntityMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Primary
@Component("sqlserver-get-all-products-use-case")
public class GetAllProductUseCaseImpl implements GetAllProductUseCase {
    @Qualifier("sqlserver-products")
    private final ProductRepository productRepository;
    @Qualifier("sqlserver-product-mapper")
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
