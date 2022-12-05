package com.phpn.dto.customer;


import com.phpn.dto.employee.EmployeeResult;
import com.phpn.dto.shipping_address.ShippingAddressResult;
import com.phpn.repositories.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.time.Instant;
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

    private CustomerStatus customerStatus;

    private Instant createAt;

    private Instant updateAt;

    private Integer locationRegionId;
    private ShippingAddressResult shippingAddressDefault;
    private List<ShippingAddressResult> shippingAddressList;

    private CustomerGender customerGender;

    private Integer employeeId;

    private EmployeeResult employeeResult;


}

