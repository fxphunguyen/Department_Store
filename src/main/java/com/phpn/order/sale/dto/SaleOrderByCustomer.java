package com.phpn.order.sale.dto;

import com.phpn.employee.dto.EmployeeResult;
import com.phpn.product.dto.ProductResult;
import com.phpn.product.item.ItemResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class SaleOrderByCustomer {
    private Integer id;

    private Integer orderId;

    private  String orderCode;

    private EmployeeResult employeeResult;

    private BigDecimal grandTotal;

    private BigDecimal total;

    private ItemResult item;

    private Integer quantity;

    private ProductResult product;

    private Instant createAt;


}
