package com.phpn.dto.orderItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OrderItemExport {

    private Integer id;

    private BigDecimal price;

    private Integer quantity;

    private Integer productId;

    private BigDecimal discount;
}
