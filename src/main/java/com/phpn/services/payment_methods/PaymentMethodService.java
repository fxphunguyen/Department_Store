package com.phpn.services.payment_methods;

import java.util.List;
import com.phpn.dto.payment_methods.PaymentMethodResult;

public interface PaymentMethodService {

    List<PaymentMethodResult> findAll();

    PaymentMethodResult findById(Integer id);

}