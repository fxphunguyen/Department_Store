package com.phpn.order.sale.dto;

import com.phpn.product.item.ItemResult;
import com.phpn.product.dto.ProductResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class OrderItemResult {

    private Integer id;

    private Integer orderId;

    private BigDecimal total;

    private ItemResult item;

    private Integer quantity;

    private ProductResult product;

    private Instant createAt;


}
