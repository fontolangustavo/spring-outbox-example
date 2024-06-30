package com.fontolan.springoutboxexample.controllers.customer.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductRequest {
    private String name;
    private double price;
}