package com.fontolan.springoutboxexample.controllers.customer;

import com.fontolan.springoutboxexample.controllers.customer.mapper.ProductMapper;
import com.fontolan.springoutboxexample.controllers.customer.response.ProductResponse;
import com.fontolan.springoutboxexample.models.Product;
import com.fontolan.springoutboxexample.usecases.GetAllProductUseCase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/v1/customer/products")
@RestController("customer-products")
public class ProductController {
    private final GetAllProductUseCase getAllProductUseCase;
    private final ProductMapper productMapper;

    public ProductController(
        @Qualifier("mongodb-get-all-products-use-case")
        GetAllProductUseCase getAllProductUseCase,
        @Qualifier("customer.product-mapper")
        ProductMapper productMapper
    ) {
        this.getAllProductUseCase = getAllProductUseCase;
        this.productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAll() {
        Page<Product> products = getAllProductUseCase.getAll();

        return ResponseEntity.ok().body(products.map(productMapper::toProductResponse));
    }
}
