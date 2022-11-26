package com.phpn.repositories.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import org.jetbrains.annotations.NotNull;

public enum TypeTax {

    IN("TAX_IN"),
    OUT("TAX_OUT");

    private final String value;

    TypeTax(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static @NotNull TypeTax parseTypeTax(String value) {
        TypeTax[] values = values();
        for (TypeTax typeTax : values) {
            if (typeTax.value.equals(value)) return typeTax;
        }
        throw new IllegalArgumentException("The supplier status [" + value + "] is invalid!");
    }
}
