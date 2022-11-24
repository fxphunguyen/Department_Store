package com.phpn.mappers;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import com.phpn.dto.payment_methods.PaymentMethodParam;
import com.phpn.dto.payment_methods.PaymentMethodResult;
import com.phpn.repositories.model.PaymentMethod;

@Component
public class PaymentMethodMapper {

    public PaymentMethodResult toDTO(@NotNull PaymentMethod paymentMethod) {
        return new PaymentMethodResult()
        .setId(paymentMethod.getId())
        .setTitle(paymentMethod.getTitle());
    }

    public PaymentMethod toModel(@NotNull PaymentMethodResult paymentMethodResult) {
        return new PaymentMethod(paymentMethodResult.getId())
        .setId(paymentMethodResult.getId())
        .setTitle(paymentMethodResult.getTitle());
    }

    public PaymentMethod toModel(@NotNull PaymentMethodParam paymentMethodParam) {
        return new PaymentMethod(paymentMethodParam.getId())
        .setId(paymentMethodParam.getId())
        .setTitle(paymentMethodParam.getTitle());
    }

}