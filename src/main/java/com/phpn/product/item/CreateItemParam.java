package com.phpn.product.item;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class CreateItemParam {

    private Integer productId;

    private Integer employeeId;

    private Integer quantity;

    private BigDecimal price;

    private Integer available;

}
