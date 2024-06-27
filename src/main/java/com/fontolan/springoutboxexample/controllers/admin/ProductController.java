package com.fontolan.springoutboxexample.controllers.admin;

import com.fontolan.springoutboxexample.usecases.ApproveProductRequestUpdateUseCase;
import com.fontolan.springoutboxexample.usecases.ProcessProductRequestUpdateUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/admin/products")
@RestController("admin-products")
public class ProductController {
    private final ApproveProductRequestUpdateUseCase approveProductRequestUpdateUseCase;
    private final ProcessProductRequestUpdateUseCase processProductRequestUpdateUseCase;

    public ProductController(
            ApproveProductRequestUpdateUseCase approveProductRequestUpdateUseCase,
            ProcessProductRequestUpdateUseCase processProductRequestUpdateUseCase
    ) {
        this.approveProductRequestUpdateUseCase = approveProductRequestUpdateUseCase;
        this.processProductRequestUpdateUseCase = processProductRequestUpdateUseCase;
    }

    @PostMapping("/{id}/approve")
    public ResponseEntity<Void> approve(@PathVariable Long id) {
        approveProductRequestUpdateUseCase.approve(id);

        processProductRequestUpdateUseCase.process(id);

        return ResponseEntity.noContent().build();
    }
}