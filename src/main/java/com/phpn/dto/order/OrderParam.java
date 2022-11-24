package com.phpn.dto.order;

import com.phpn.dto.customer.CustomerParam;
import com.phpn.dto.employee.EmployeeParam;
import com.phpn.dto.orderItem.OrderItemParam;
import com.phpn.dto.payment_methods.PaymentMethodParam;
import com.phpn.repositories.model.Item;
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
public class OrderParam {

    private Integer id;

    private Integer employeeId;

    private Integer customerId;

    private Integer paymentMethodId;

    private BigDecimal tax;

    private BigDecimal discount;

    private String description;

    private String createAt;

    private BigDecimal total;

    private BigDecimal grandTotal;

    List<OrderItemParam> orderItems;

}
