package com.phpn.supplier;

import com.phpn.employee.dto.EmployeeResult;
import com.phpn.order.PaymentMethodResult;
import vn.fx.qh.sapo.entities.product.supplier.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SupplierResult {

    private Integer id;
    private String supplierCode;
    private String name;
    private String email;
    private String phone;
    private SupplierStatus status;
    private String description;
    private Integer employeeId;
    private EmployeeResult employee;
    private Integer paymentMethodId;
    private PaymentMethodResult paymentMethod;
    private String createAt;
    private String updateAt;

}