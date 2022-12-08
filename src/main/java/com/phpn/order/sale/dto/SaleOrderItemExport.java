package com.phpn.order.sale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class SaleOrderItemExport {

    private Integer id;

    private BigDecimal price;

    private Integer quantity;

    private Integer productId;

    private BigDecimal discount;

    private Float tax;
}
