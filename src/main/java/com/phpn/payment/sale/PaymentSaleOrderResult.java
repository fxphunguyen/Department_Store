package com.phpn.payment.sale;

import com.phpn.employee.dto.EmployeeResult;
import com.phpn.order.sale.dto.SaleOrderResult;
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

    private SaleOrderResult orderResult;

    private Integer paymentMethodId;

    private String createAt;

    private String description;
}
