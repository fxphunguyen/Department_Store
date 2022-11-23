package com.phpn.dto.orderItem;

import com.phpn.dto.item.ItemParam;
import com.phpn.dto.order.OrderParam;
import com.phpn.dto.product.ProductParam;
import com.phpn.repositories.model.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class OrderItemParam {

    private Integer id;

    private OrderParam orderParam;

    private BigDecimal total;

    private ItemParam itemParam;

    private Integer quantity;

    private ProductParam productParam;


}
