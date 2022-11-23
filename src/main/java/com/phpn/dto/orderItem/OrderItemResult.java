package com.phpn.dto.orderItem;

import com.phpn.dto.item.ItemParam;
import com.phpn.dto.item.ItemResult;
import com.phpn.dto.order.OrderParam;
import com.phpn.dto.order.OrderResult;
import com.phpn.dto.product.ProductParam;
import com.phpn.dto.product.ProductResult;
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
