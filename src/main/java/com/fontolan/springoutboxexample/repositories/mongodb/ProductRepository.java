package com.fontolan.springoutboxexample.repositories.mongodb;


import com.fontolan.springoutboxexample.entities.mongodb.ProductEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository("mongodb-products")
public interface ProductRepository extends MongoRepository<ProductEntity, String> {
}