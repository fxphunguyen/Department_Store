package com.phpn.repositories.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CustomerGender {

    NAM("NAM"), NU("NU");

    private final String value;

    CustomerGender(String value) {
        this.value = value;
    }
    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static CustomerGender parseOrderGender(String value) {
        CustomerGender[] values = values();
        for (CustomerGender customerStatus : values) {
            if (customerStatus.value.equals(value)) return customerStatus;
        }
        throw new IllegalArgumentException(value + "invalid");
    }
}
