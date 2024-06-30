package com.fontolan.springoutboxexample.controllers.admin.response;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductResponse {
    private String id;
    private String name;
    private double price;
}
