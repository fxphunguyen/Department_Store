package com.phpn.mappers;

import com.phpn.dto.payment.PaymentParam;
import com.phpn.dto.payment.PaymentResult;
import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.mappers.purchase_order.PurchaseOrderMapper;
import com.phpn.repositories.model.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    @Autowired
    private PurchaseOrderMapper purchaseOrderMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public PaymentResult toDTO(Payment payment) {
        return new  PaymentResult()
                .setId(payment.getId())
                .setPaid(payment.getPaid())
                .setCreateAt(payment.getCreateAt())
                .setEmployeeResult(employeeMapper.toDTO(payment.getEmployee()))
                .setPaymentMethodId(payment.getPaymentMethodId())
                .setPurchaseOrderResult(purchaseOrderMapper.toDTO(payment.getPurchaseOrder()));
    }

    public Payment toModel(PaymentParam paymentParam) {
        return new Payment()
                .setId(paymentParam.getId())
                .setPaid(paymentParam.getPaid())
                .setCreateAt(paymentParam.getCreateAt())
                .setEmployeeId(paymentParam.getEmployeeId())
                .setPurchaseOrderId(paymentParam.getPurchaseOrderId())
                .setPaymentMethodId(paymentParam.getPaymentMethodId());
    }
}
