package com.fontolan.springoutboxexample.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product {
    private String id;
    private String externalId;
    private String name;
    private double price;
}
