package com.phpn.dto.paymentOrder;

import com.phpn.dto.customer.CustomerResult;
import com.phpn.dto.employee.EmployeeResult;
import com.phpn.dto.order.OrderResult;
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
public class PaymentOrderParam {

    private Integer id;

    private BigDecimal paid;

    private Integer employeeId;

    private EmployeeResult employeeResult;

    private Integer orderId;

    private OrderResult orderResult;

    private Integer customerId;

    private CustomerResult customerResult;

    private Integer paymentMethodId;

    private String createAt;

    private String description;
}
