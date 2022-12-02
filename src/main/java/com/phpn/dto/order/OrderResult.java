package com.phpn.dto.order;

import com.phpn.dto.customer.CustomerOrderResult;
import com.phpn.dto.employee.EmployeeResult;
import com.phpn.dto.orderItem.OrderItemResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OrderResult {

    private Integer id;

    private Integer employeeId;

    private EmployeeResult employee;

    private String orderCode;

    private Integer orderStatusId;

    private BigDecimal discount;

    private String description;

    private Instant createAt;

    private Integer customerId;

    private CustomerOrderResult customer;

    private BigDecimal total;

    private BigDecimal subTotal;

    private BigDecimal grandTotal;

    List<OrderItemResult> orderItems;

}