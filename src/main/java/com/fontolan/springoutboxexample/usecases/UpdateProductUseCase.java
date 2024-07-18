package com.fontolan.springoutboxexample.usecases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fontolan.springoutboxexample.models.Product;

public interface UpdateProductUseCase {
    void update(Product product) throws JsonProcessingException;
}
