package com.phpn.repositories.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum OrderStatusCode {
    UNPAID("UNPAID"),
    PAID("PAID"),
    PARTIAL_PAYMENT("PARTIAL_PAYMENT"),
    NEW("NEW"),
    CHECKOUT("CHECKOUT"),
    FAILED("FAILED"),
    SHIPPED("SHIPPED"), SHIPPING("SHIPPING"),
    DELIVERED("DELIVERED"), RETURNED("RETURNED"),
    COMPLETE("RETURNED"),
    CANCELED("CANCELED");
    private final String value;

    OrderStatusCode(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static OrderStatusCode parseOrderCodeStatus(String value) {
        OrderStatusCode[] values = values();
        for (OrderStatusCode status : values) {
            if (status.value.equals(value))
                return status;
        }
        throw new IllegalArgumentException(value + "invalid");
    }
}
