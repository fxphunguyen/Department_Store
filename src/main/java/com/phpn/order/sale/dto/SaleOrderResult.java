package com.phpn.order.sale.dto;

import com.phpn.customer.dto.CustomerResult;
import com.phpn.employee.dto.EmployeeResult;
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
public class SaleOrderResult {

    private Integer id;

    private String fullName;

    private String mobile;

    private String line1;

    private String line2;

    private String city;

    private String province;

    private String zipCode;

    private Integer employeeId;

    private EmployeeResult employee;

    private String orderCode;

    private String orderStatusId;

    private SaleOrderStatusResult orderStatus;

    private String paymentStatusId;

    private SaleOrderStatusResult paymentStatus;

    private BigDecimal discount;

    private String description;

    private Instant createdAt;

    private Instant updatedAt;

    private Integer customerId;

    private CustomerResult customer;

    private BigDecimal total;

    private BigDecimal subTotal;

    private BigDecimal grandTotal;

    private List<SaleOrderItemResult> orderItems;

}