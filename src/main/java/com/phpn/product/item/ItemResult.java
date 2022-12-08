package com.phpn.product.item;

import com.phpn.employee.dto.EmployeeResult;
import com.phpn.product.dto.ProductResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class ItemResult {

    private Integer id;

    private Integer productId;

    private Integer employeeId;

    private EmployeeResult employee;

    private Integer supplierId;

    private Integer purchaseOrderId;

    private Integer quantity;

    private BigDecimal price;

    private String sku;

    private Float discount;

    private Integer available;

    private Integer trading;

    private ProductResult productResult;


}
