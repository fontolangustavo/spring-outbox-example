package com.fontolan.springoutboxexample.enums;

public enum ProductRequestUpdateEnum {
    WAITING_APPROVE("WAITING_APPROVE"),
    APPROVED("APPROVED"),
    UPDATED("UPDATED"),
    DISAPPROVED("DISAPPROVED"),
    ERROR("ERROR");

    private String status;

    ProductRequestUpdateEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
