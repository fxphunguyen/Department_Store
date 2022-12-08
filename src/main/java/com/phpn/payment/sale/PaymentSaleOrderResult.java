package com.phpn.order.sale.dto;

import com.phpn.employee.dto.EmployeeResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PaymentSaleOrderResult {

    private Integer id;

    private BigDecimal paid;

    private Integer employeeId;

    private EmployeeResult employeeResult;

    private Integer orderId;

    private OrderResult orderResult;

    private Integer paymentMethodId;

    private String createAt;

    private String description;
}
