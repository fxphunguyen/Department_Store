package com.phpn.dto.item;

import com.phpn.dto.employee.EmployeeResult;
import com.phpn.repositories.model.Employee;
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

    private Integer supplierId;

    private Integer orderId;

    private Integer quantity;

    private BigDecimal price;

    private String sku;

    private Float discount;


}
