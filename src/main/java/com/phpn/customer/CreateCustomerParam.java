package com.phpn.dto.customer;


import com.phpn.dto.shipping_address.CreateShippingAddressParam;
import vn.fx.qh.sapo.entities.CustomerGender;
import vn.fx.qh.sapo.entities.CustomerGroup;
import vn.fx.qh.sapo.entities.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

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
