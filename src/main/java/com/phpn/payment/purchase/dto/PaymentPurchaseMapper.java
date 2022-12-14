package com.phpn.payment.purchase.dto;

import com.phpn.employee.dto.EmployeeMapper;
import com.phpn.order.purchase.dto.PurchaseOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.fx.qh.sapo.entities.payment.purchase.PaymentPurchaseOrder;

@Component
public class PaymentPurchaseMapper {

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public PaymentPurchaseResult toDTO(PaymentPurchaseOrder paymentPurchase) {
        return new PaymentPurchaseResult()
                .setId(paymentPurchase.getId())
                .setPaid(paymentPurchase.getPaid())
                .setEmployeeResult(employeeMapper.toDTO(paymentPurchase.getEmployee()))
                .setPaymentMethodId(paymentPurchase.getPaymentMethodId());
    }

    public PaymentPurchaseOrder toModel(PaymentPurchaseParam paymentParam) {
        return new PaymentPurchaseOrder()
                .setId(paymentParam.getId())
                .setPaid(paymentParam.getPaid())
                .setEmployeeId(paymentParam.getEmployeeId())
                .setPurchaseOrderId(paymentParam.getPurchaseOrderId())
                .setPaymentMethodId(paymentParam.getPaymentMethodId());
    }
}
