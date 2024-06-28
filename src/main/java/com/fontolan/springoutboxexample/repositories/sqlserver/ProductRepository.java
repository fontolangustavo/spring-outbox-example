package com.fontolan.springoutboxexample.repositories.sqlserver;

import com.fontolan.springoutboxexample.entities.sqlserver.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("sqlserver-products")
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByExternalId(final String externalId);
}
