package com.fontolan.springoutboxexample.usecases;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fontolan.springoutboxexample.controllers.partner.request.ProductRequest;
import com.fontolan.springoutboxexample.models.Product;
import org.springframework.stereotype.Component;

public interface CreateProductUseCase {
    public Product store(final Product product) throws JsonProcessingException;
}
