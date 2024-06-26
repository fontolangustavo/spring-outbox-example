package com.fontolan.springoutboxexample.repositories.sqlserver;

import com.fontolan.springoutboxexample.entities.sqlserver.ProductEntity;
import com.fontolan.springoutboxexample.entities.sqlserver.ProductRequestUpdateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRequestUpdateRepository extends JpaRepository<ProductRequestUpdateEntity, Long> {
}
