package com.phpn.customer.dto;

import vn.fx.qh.sapo.entities.customer.*;

import java.math.BigDecimal;
import java.time.Instant;

public class HistoryCustomerOrder {
    private BigDecimal price;

    private Integer quantity;

    private Instant create;

    private String email;

    private String birthday;

    private String status;

    private String createAt;

    private String updateAt;

    private CustomerGender customerGender;
}
