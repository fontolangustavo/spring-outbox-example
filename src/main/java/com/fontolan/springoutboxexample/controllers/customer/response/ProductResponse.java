package com.fontolan.springoutboxexample.controllers.customer.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductResponse {
    private Long id;
    private String name;
    private double price;
}
