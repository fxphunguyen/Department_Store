package com.phpn.dto.customer;

import com.phpn.dto.employee.EmployeeResult;
import vn.fx.qh.sapo.entities.ShippingAddress;
import lombok.*;
import lombok.experimental.Accessors;

import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class CustomerOrderResult {

    private Integer id;

    private String customerCode;

    private String name;

    private String phone;

    private Set<ShippingAddress> shippingAddressSet;

    private Integer employeeId;

    private EmployeeResult employee;

    private Boolean deleted;


}

