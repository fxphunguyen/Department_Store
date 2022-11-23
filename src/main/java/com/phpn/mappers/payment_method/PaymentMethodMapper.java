package com.phpn.mappers.payment_method;

import com.phpn.dto.payment_method.PaymentMethodParam;
import com.phpn.dto.payment_method.PaymentMethodResult;
import com.phpn.repositories.model.PaymentMethod;
import org.springframework.stereotype.Component;

@Component
public class PaymentMethodMapper {
    public PaymentMethodResult toDTO(PaymentMethod paymentMethod) {
        return new PaymentMethodResult()
                .setId(paymentMethod.getId())
                .setTitle(paymentMethod.getTitle());
    }

    public PaymentMethod toModel(PaymentMethodParam paymentMethodParam) {
        return new PaymentMethod()
                .setId(paymentMethodParam.getId())
                .setTitle(paymentMethodParam.getTitle());
    }
}
