package com.phpn.order.sale.dto;

import lombok.*;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
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
