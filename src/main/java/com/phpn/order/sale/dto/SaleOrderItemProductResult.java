package com.phpn.order.sale.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class SaleOrderItemProductResult {
    private Integer id;
    private String title;
    private String mainUrl;


}
