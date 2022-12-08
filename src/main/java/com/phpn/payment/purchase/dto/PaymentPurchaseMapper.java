package com.phpn.payment.purchase;

import com.phpn.order.PaymentPurchaseParam;
import com.phpn.order.PaymentPurchaseResult;
import com.phpn.employee.dto.EmployeeMapper;
import com.phpn.order.purchase.dto.PurchaseOrderMapper;
import vn.fx.qh.sapo.entities.PaymentPurchase;
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
                .setCreateAt(paymentPurchase.getCreateAt())
                .setEmployeeResult(employeeMapper.toDTO(paymentPurchase.getEmployee()))
                .setPaymentMethodId(paymentPurchase.getPaymentMethodId())
                .setPurchaseOrderResult(purchaseOrderMapper.toDTO(paymentPurchase.getPurchaseOrder()));
    }

    public PaymentPurchaseOrder toModel(PaymentPurchaseParam paymentParam) {
        return new PaymentPurchaseOrder()
                .setId(paymentParam.getId())
                .setPaid(paymentParam.getPaid())
                .setCreateAt(paymentParam.getCreateAt())
                .setEmployeeId(paymentParam.getEmployeeId())
                .setPurchaseOrderId(paymentParam.getPurchaseOrderId())
                .setPaymentMethodId(paymentParam.getPaymentMethodId());
    }
}
