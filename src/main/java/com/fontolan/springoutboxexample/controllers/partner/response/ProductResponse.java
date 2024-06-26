package com.fontolan.springoutboxexample.controllers.partner.response;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductResponse {
    private Long id;
    private String name;
    private double price;
}
