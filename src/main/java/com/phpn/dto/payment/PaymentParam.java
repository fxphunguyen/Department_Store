package com.phpn.dto.payment;

import com.phpn.dto.employee.EmployeeResult;
import com.phpn.dto.purchase_order.PurchaseOrderResult;
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
public class PaymentParam {

    private Integer id;

    private BigDecimal paid;

    private Integer employeeId;

    private EmployeeResult employeeResult;

    private Integer purchaseOrderId;

    private PurchaseOrderResult purchaseOrderResult;

    private Integer paymentMethodId;

    private Date createAt;

}
