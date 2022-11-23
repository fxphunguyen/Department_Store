package com.phpn.dto.purchase_order;

import com.phpn.dto.employee.EmployeeResult;
import com.phpn.dto.suppliers.SupplierResult;
import com.phpn.repositories.model.PurchaseOrderPays;
import com.phpn.repositories.model.PurchaseOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PurchaseOrderResult {

    private Integer id;

    private String purchaseOrderCode;

    private SupplierResult supplierResult;

    private Integer supplierId;

    private Integer employeeId;

    private EmployeeResult employeeResult;

    private Integer paymentMethodId;

    private PurchaseOrderStatus status;

    private PurchaseOrderPays pays;

    private BigDecimal grandTotal;



}
