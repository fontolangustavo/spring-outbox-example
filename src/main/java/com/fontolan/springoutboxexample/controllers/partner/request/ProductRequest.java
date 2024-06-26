package com.fontolan.springoutboxexample.controllers.partner.request;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductRequest {
    private String name;
    private double price;
}
