package com.fontolan.springoutboxexample.controllers.customer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fontolan.springoutboxexample.controllers.partner.mapper.ProductMapper;
import com.fontolan.springoutboxexample.controllers.partner.request.ProductRequest;
import com.fontolan.springoutboxexample.controllers.partner.response.ProductResponse;
import com.fontolan.springoutboxexample.models.Product;
import com.fontolan.springoutboxexample.usecases.CreateProductUseCase;
import com.fontolan.springoutboxexample.usecases.GetAllProductUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/customer/products")
@RestController("customer-products")
public class ProductController {
    private final GetAllProductUseCase getAllProductUseCase;
    private final ProductMapper productMapper;

    public ProductController(GetAllProductUseCase getAllProductUseCase, ProductMapper productMapper) {
        this.getAllProductUseCase = getAllProductUseCase;
        this.productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAll() {
        Page<Product> products = getAllProductUseCase.getAll();

        return ResponseEntity.ok().body(products.map(productMapper::toProductResponse));
    }
}
