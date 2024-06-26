package com.fontolan.springoutboxexample.controllers.partner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fontolan.springoutboxexample.controllers.partner.mapper.ProductMapper;
import com.fontolan.springoutboxexample.controllers.partner.request.ProductRequest;
import com.fontolan.springoutboxexample.controllers.partner.response.ProductResponse;
import com.fontolan.springoutboxexample.models.Product;
import com.fontolan.springoutboxexample.usecases.CreateProductUseCase;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/partner/products")
@RestController("partner-products")
public class ProductController {
    private final CreateProductUseCase createProductUseCase;
    private final ProductMapper productMapper;

    public ProductController(CreateProductUseCase createProductUseCase, ProductMapper productMapper) {
        this.createProductUseCase = createProductUseCase;
        this.productMapper = productMapper;
    }

    // partner - simulation - create a new product
    @PostMapping
    public ResponseEntity<ProductResponse> store(@Valid @ModelAttribute ProductRequest request) throws JsonProcessingException {
        Product product = createProductUseCase.store(productMapper.toProduct(request));

        return ResponseEntity.ok().body(productMapper.toProductResponse(product));
    }
}
