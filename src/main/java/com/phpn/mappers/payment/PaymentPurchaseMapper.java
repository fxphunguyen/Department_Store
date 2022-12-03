package com.phpn.mappers.payment;

import com.phpn.dto.paymentPurchase.PaymentPurchaseParam;
import com.phpn.dto.paymentPurchase.PaymentPurchaseResult;
import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.mappers.purchase_order.PurchaseOrderMapper;
import com.phpn.repositories.model.PaymentPurchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentPurchaseMapper {

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public PaymentPurchaseResult toDTO(PaymentPurchase paymentPurchase) {
        return new PaymentPurchaseResult()
                .setId(paymentPurchase.getId())
                .setPaid(paymentPurchase.getPaid())
                .setCreateAt(paymentPurchase.getCreateAt())
                .setEmployeeResult(employeeMapper.toDTO(paymentPurchase.getEmployee()))
                .setPaymentMethodId(paymentPurchase.getPaymentMethodId())
                .setPurchaseOrderResult(purchaseOrderMapper.toDTO(paymentPurchase.getPurchaseOrder()));
    }

    public PaymentPurchase toModel(PaymentPurchaseParam paymentParam) {
        return new PaymentPurchase()
                .setId(paymentParam.getId())
                .setPaid(paymentParam.getPaid())
                .setCreateAt(paymentParam.getCreateAt())
                .setEmployeeId(paymentParam.getEmployeeId())
                .setPurchaseOrderId(paymentParam.getPurchaseOrderId())
                .setPaymentMethodId(paymentParam.getPaymentMethodId());
    }
}
