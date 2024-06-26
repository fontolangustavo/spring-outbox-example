package com.fontolan.springoutboxexample.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductRequestUpdate {
    private Long id;
    private Product product;
    private String oldData;
    private String newData;
    private String status;
}
