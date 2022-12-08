package com.phpn.payment.purchase;

import com.phpn.employee.dto.EmployeeResult;
import com.phpn.order.purchase.dto.PurchaseOrderResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PaymentPurchaseCreate {

    private Integer id;

    private BigDecimal paid;

    private Integer employeeId;

    private EmployeeResult employee;

    private Integer purchaseOrderId;

    private PurchaseOrderResult purchaseOrder;

    private Integer paymentMethodId;

    private Date createAt;
}
