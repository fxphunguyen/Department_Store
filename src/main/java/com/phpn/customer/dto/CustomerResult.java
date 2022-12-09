package com.phpn.customer.dto;


import com.phpn.shipping_address.dto.ShippingAddressResult;
import com.phpn.employee.dto.EmployeeResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;
import vn.fx.qh.sapo.entities.customer.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class CustomerResult {

    private Integer id;

    private String customerCode;

    private String name;

    private String phone;

    private CustomerGroup customerGroup;

    private String email;

    private String birthday;

    private BigDecimal debtTotal;

    private BigDecimal spendTotal;

    private CustomerStatus customerStatus;

    private Instant createAt;

    private Instant updateAt;

    private EmployeeResult employeeResult;

    private ShippingAddressResult shippingAddress;

    private ShippingAddressResult billAddress;

    private List<ShippingAddressResult> shippingAddressList;

    private CustomerGender customerGender;

    private Integer employeeId;

    private EmployeeResult employee;

    private Integer quantityProductOrder;

    private  Integer quantityItemOrder;

    private Instant lastDayOrder;

}

