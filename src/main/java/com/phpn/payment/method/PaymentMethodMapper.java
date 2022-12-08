package com.phpn.payment.method;

import org.springframework.stereotype.Component;

import com.phpn.order.PaymentMethodParam;
import com.phpn.order.PaymentMethodResult;
import vn.fx.qh.sapo.entities.payment.*;

@Component
public class PaymentMethodMapper {

    public PaymentMethodResult toDTO(PaymentMethod paymentMethod) {
        return new PaymentMethodResult()
        .setId(paymentMethod.getId())
        .setTitle(paymentMethod.getTitle());
    }

    public PaymentMethod toModel(PaymentMethodResult paymentMethodResult) {
        return new PaymentMethod(paymentMethodResult.getId())
        .setId(paymentMethodResult.getId())
        .setTitle(paymentMethodResult.getTitle());
    }

    public PaymentMethod toModel(PaymentMethodParam paymentMethodParam) {
        return new PaymentMethod(paymentMethodParam.getId())
        .setId(paymentMethodParam.getId())
        .setTitle(paymentMethodParam.getTitle());
    }

}