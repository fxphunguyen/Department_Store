package com.phpn.services.paymentOrder;


import com.phpn.dto.paymentOrder.PaymentOrderParam;
import com.phpn.dto.paymentOrder.PaymentOrderResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PaymentOrderService {

    List<PaymentOrderResult> findAll();

    @Transactional(readOnly = true)
    List<PaymentOrderResult> findAllByOrderId(Integer orderId);

    PaymentOrderResult createPaymentOrder(PaymentOrderParam paymentOrderParam);

}
