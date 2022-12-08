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
public class SaleOrderItemParam {

    private Integer id;

    private Integer orderId;

    private Integer itemId;

    private Integer quantity;

    private Integer productId;

    private BigDecimal price;

    private Float tax;
}
