package com.fontolan.springoutboxexample.controllers.admin;

import com.fontolan.springoutboxexample.controllers.admin.mapper.ProductMapper;
import com.fontolan.springoutboxexample.controllers.admin.response.ProductResponse;
import com.fontolan.springoutboxexample.models.Product;
import com.fontolan.springoutboxexample.usecases.ApproveProductRequestUpdateUseCase;
import com.fontolan.springoutboxexample.usecases.GetAllProductUseCase;
import com.fontolan.springoutboxexample.usecases.ProcessProductRequestUpdateUseCase;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/admin/products")
@RestController("admin-products")
public class ProductController {
    private final ApproveProductRequestUpdateUseCase approveProductRequestUpdateUseCase;
    private final ProcessProductRequestUpdateUseCase processProductRequestUpdateUseCase;
    private final GetAllProductUseCase getAllProductUseCase;
    private final ProductMapper productMapper;

    public ProductController(
        ApproveProductRequestUpdateUseCase approveProductRequestUpdateUseCase,
        ProcessProductRequestUpdateUseCase processProductRequestUpdateUseCase,
        @Qualifier("sqlserver-get-all-products-use-case")
        GetAllProductUseCase getAllProductUseCase,
        @Qualifier("admin.product-mapper")
        ProductMapper productMapper
    ) {
        this.approveProductRequestUpdateUseCase = approveProductRequestUpdateUseCase;
        this.processProductRequestUpdateUseCase = processProductRequestUpdateUseCase;
        this.getAllProductUseCase = getAllProductUseCase;
        this.productMapper = productMapper;
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAll() {
        Page<Product> products = getAllProductUseCase.getAll();

        return ResponseEntity.ok().body(products.map(productMapper::toProductResponse));
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<Void> approve(@PathVariable Long id) {
        approveProductRequestUpdateUseCase.approve(id);

        processProductRequestUpdateUseCase.process(id);

        return ResponseEntity.noContent().build();
    }
}