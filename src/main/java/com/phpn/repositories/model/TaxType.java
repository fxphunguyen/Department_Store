package com.phpn.repositories.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.jetbrains.annotations.NotNull;

public enum TaxType {

    IN("TAX_IN"),
    OUT("TAX_OUT");

    private final String value;

    TaxType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static @NotNull TaxType parseTypeTax(String value) {
        TaxType[] values = values();
        for (TaxType typeTax : values) {
            if (typeTax.value.equals(value)) return typeTax;
        }
        throw new IllegalArgumentException("Tax type [" + value + "] is invalid!");
    }
}
