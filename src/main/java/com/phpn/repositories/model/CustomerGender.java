package com.phpn.repositories.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;

public enum CustomerGender {

    NAM("Nam"), NU("Nữ"),KHAC("Khác");

    private final String value;



    CustomerGender(String value) {
        this.value = value;
    }
    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static CustomerGender parseCustomerGender(String value) {
        CustomerGender[] values = values();
        for (CustomerGender customerGender : values) {
            if (customerGender.value.equals(value)) return customerGender;
        }
        throw new IllegalArgumentException(value + "invalid");
    }


    @JsonCreator
    public static List<CustomerGender> parseLickCustomerGender(String value) {

        for (CustomerGender customerGender : CustomerGender.values()) {

        }
        throw new IllegalArgumentException(value + "invalid");
    }

}
