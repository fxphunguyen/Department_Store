package com.phpn.customer.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import vn.fx.qh.sapo.entities.customer.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class CreateCustomerParam {


    private Integer id;

    private String customerCode;

    private String name;

    private String phone;

    private CustomerGroup customerGroup;

    private String email;

    private String birthday;

    private CustomerGender customerGender;

    private CustomerStatus customerStatus;

    private Integer employeeId;


    private CreateShippingAddressParam createShippingAddressParam;



}
