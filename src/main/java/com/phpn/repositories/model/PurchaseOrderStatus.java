package com.phpn.repositories.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum PurchaseOrderStatus {
    SUCCESS("Hoàn thành"),
    AVAILABLE("Đang giao dịch");

    private final String value;

    PurchaseOrderStatus(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static PurchaseOrderStatus parsePurchaseOrderStatus(String value) {
        PurchaseOrderStatus[] values = values();
        for (PurchaseOrderStatus purchaseOrderStatus : values) {
            if (purchaseOrderStatus.value.equals(value)) return purchaseOrderStatus;
        }
        throw new IllegalArgumentException(value + "invalid");
    }
}
