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
public class ItemParam {

    private Integer id;

    private Integer productId;

    private Integer employeeId;

    private Integer supplierId;

    private Integer purchaseOrderId;

    private Integer quantity;

    private BigDecimal price;

    private String sku;

    private Float discount;

    private int available;



}
