package com.phpn.dto.order;



import com.phpn.dto.customer.CustomerResult;

import com.phpn.dto.employee.EmployeeResult;

import com.phpn.dto.orderItem.OrderItemExport;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OrderParam {

    private Integer id;

    private Integer employeeId;

    private EmployeeResult employeeResult;

    private Integer customerId;

    private CustomerResult customerResult;

    private BigDecimal tax;

    private BigDecimal discount;

    private String description;

    private Integer orderStatusId;

    private Instant createAt;

    List<OrderItemExport> orderItems;

}
