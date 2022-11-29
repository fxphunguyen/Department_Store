package com.phpn.dto.order;

import com.phpn.dto.customer.CustomerResult;
import com.phpn.dto.employee.EmployeeResult;
import com.phpn.dto.orderItem.OrderItemResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OrderResult {

    private Integer id;

    private EmployeeResult employee;

    private String orderCode;

    private CustomerResult customer;

    private String status;

    private BigDecimal discount;

    private String description;

    private String createAt;

    private BigDecimal total;

    private BigDecimal grandTotal;

    List<OrderItemResult> orderItems;

}
