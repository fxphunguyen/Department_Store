package com.phpn.dto.purchase_order;

import com.phpn.repositories.model.PurchaseOrderPays;
import com.phpn.repositories.model.PurchaseOrderStatus;
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
public class PurchaseOrderParam {

    private Integer id;

    private String purchaseCode;

    private Integer supplierId;

    private Integer purchaseOrderItemId;

    private Integer employeeId;

    private Integer paymentMethodId;

    private PurchaseOrderStatus status;

    private PurchaseOrderPays pays;

    

}
