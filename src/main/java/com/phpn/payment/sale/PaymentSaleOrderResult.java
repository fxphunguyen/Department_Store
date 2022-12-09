package com.phpn.payment.sale;

import com.phpn.employee.dto.EmployeeResult;
import com.phpn.order.sale.dto.SaleOrderResult;
import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@ToString
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

    private Instant createdAt;

    private String description;
}
