package com.phpn.payment.method;

import java.util.List;
import com.phpn.order.PaymentMethodResult;

public interface PaymentMethodService {

    List<PaymentMethodResult> findAll();

    PaymentMethodResult findById(Integer id);

}