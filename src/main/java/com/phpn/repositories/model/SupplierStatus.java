package com.phpn.repositories.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonCreator;

public enum SupplierStatus {

    AVAILABLE("Đang giao dịch"),
    UNAVAILABLE("Ngừng giao dịch");

    private final String value;

    SupplierStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static SupplierStatus parseSupplierStatus(String value) {
        SupplierStatus[] values = values();
        for (SupplierStatus supplierStatus : values) {
            if (supplierStatus.value.equals(value)) return supplierStatus;
        }
        throw new IllegalArgumentException(value + " is invalid!");
    }

}