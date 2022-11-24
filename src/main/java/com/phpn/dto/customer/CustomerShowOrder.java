package com.phpn.dto.customer;

import com.phpn.dto.locationRegion.LocationRegionResult;
import com.phpn.repositories.model.CustomerGender;
import com.phpn.repositories.model.CustomerGroup;

import java.math.BigDecimal;
import java.time.Instant;

public class CustomerShowOrder {
    private BigDecimal price;

    private Integer quantity;

    private Instant create;

    private String email;

    private String birthday;

    private String status;

    private String createAt;

    private String updateAt;

    private Integer locationRegionId;

    private LocationRegionResult locationRegionResult;

    private CustomerGender customerGender;
}
