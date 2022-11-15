package com.phpn.dto.purchase_order;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PurchaseOrderResult {
    private String sku;

    private Integer supplierId;

    private String status;


}
