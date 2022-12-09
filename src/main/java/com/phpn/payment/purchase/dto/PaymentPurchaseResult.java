package com.phpn.payment.purchase.dto;

import com.phpn.employee.dto.EmployeeResult;
import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PaymentPurchaseResult {

    private Integer id;

    private BigDecimal paid;

    private Integer employeeId;

    private EmployeeResult employeeResult;

    private Integer purchaseOrderId;

    private Integer paymentMethodId;

    private Instant createAt;

}
