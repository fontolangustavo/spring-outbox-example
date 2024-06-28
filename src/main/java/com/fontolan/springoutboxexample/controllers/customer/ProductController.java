package com.fontolan.springoutboxexample.controllers.customer;

import com.fontolan.springoutboxexample.controllers.partner.mapper.ProductMapper;
import com.fontolan.springoutboxexample.controllers.partner.response.ProductResponse;
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
    @Qualifier("sqlserver-get-all-products-use-case")
    private final GetAllProductUseCase getAllProductUseCase;
    @Qualifier("sqlserver-product-mapper")
    private final ProductMapper productMapper;

    public ProductController(
        GetAllProductUseCase getAllProductUseCase,
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
