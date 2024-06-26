package com.fontolan.springoutboxexample.repositories.sqlserver;

import com.fontolan.springoutboxexample.entities.sqlserver.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
