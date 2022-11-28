package com.phpn.mappers;

import com.phpn.dto.paymentPurchase.PaymentPurchaseParam;
import com.phpn.dto.paymentPurchase.PaymentPurchaseResult;
import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.mappers.purchase_order.PurchaseOrderMapper;
import com.phpn.repositories.model.PaymentPurchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public PaymentPurchaseResult toDTO(PaymentPurchase payment) {
        return new PaymentPurchaseResult()
                .setId(payment.getId())
                .setPaid(payment.getPaid())
                .setCreateAt(payment.getCreateAt())
                .setEmployeeResult(employeeMapper.toDTO(payment.getEmployee()))
                .setPaymentMethodId(payment.getPaymentMethodId())
                .setPurchaseOrderResult(purchaseOrderMapper.toDTO(payment.getPurchaseOrder()));
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
