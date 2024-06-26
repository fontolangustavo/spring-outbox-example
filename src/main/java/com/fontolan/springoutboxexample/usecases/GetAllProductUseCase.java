package com.fontolan.springoutboxexample.usecases;

import com.fontolan.springoutboxexample.models.Product;
import org.springframework.data.domain.Page;

public interface GetAllProductUseCase {
    Page<Product> getAll();
}
