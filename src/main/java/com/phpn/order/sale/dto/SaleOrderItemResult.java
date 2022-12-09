package com.phpn.order.sale.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class SaleOrderItemResult {

    private Integer id;
    private Integer orderId;
    private BigDecimal price;
    private Integer quantity;
    private Float tax;
    private BigDecimal discount;
    private ProductSaleResult product;
}
