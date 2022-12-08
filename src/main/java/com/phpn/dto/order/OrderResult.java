package com.phpn.dto.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.phpn.dto.customer.CustomerOrderResult;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.dto.employee.EmployeeResult;
import com.phpn.dto.orderItem.OrderItemResult;
import com.phpn.dto.orderStatus.OrderStatusResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OrderResult {

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

    private OrderStatusResult orderStatus;

    private String paymentStatusId;

    private OrderStatusResult paymentStatus;

    private BigDecimal discount;

    private String description;

    private Instant createAt;

    private Integer customerId;

    private CustomerResult customer;

    private BigDecimal total;

    private BigDecimal subTotal;

    private BigDecimal grandTotal;

    List<OrderItemResult> orderItems;

}