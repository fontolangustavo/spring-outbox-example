package com.fontolan.springoutboxexample.usecases.impl;

import com.fontolan.springoutboxexample.entities.sqlserver.ProductRequestUpdateEntity;
import com.fontolan.springoutboxexample.enums.ProductRequestUpdateEnum;
import com.fontolan.springoutboxexample.repositories.sqlserver.ProductRequestUpdateRepository;
import com.fontolan.springoutboxexample.usecases.ApproveProductRequestUpdateUseCase;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

@Component
public class ApproveProductRequestUpdateUseCaseImpl implements ApproveProductRequestUpdateUseCase {
    private ProductRequestUpdateRepository productRequestUpdateRepository;

    public ApproveProductRequestUpdateUseCaseImpl(
            ProductRequestUpdateRepository productRequestUpdateRepository
    ) {
        this.productRequestUpdateRepository = productRequestUpdateRepository;
    }

    @Override
    public void approve(Long id)  {
        Optional<ProductRequestUpdateEntity> productRequestUpdateEntity = productRequestUpdateRepository
                .findById(id);

        if (productRequestUpdateEntity.isEmpty()) {
            throw new RuntimeException("Product request update not found!");
        }

        ProductRequestUpdateEntity productRequestUpdate = productRequestUpdateEntity.get();
        if (!Objects.equals(productRequestUpdate.getStatus(), ProductRequestUpdateEnum.WAITING_APPROVE.getStatus())) {
            throw new RuntimeException("Product request update invalid status!");
        }

        productRequestUpdate.setStatus(ProductRequestUpdateEnum.APPROVED.getStatus());

        productRequestUpdateRepository.save(productRequestUpdate);
    }
}
