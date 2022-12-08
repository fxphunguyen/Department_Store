package com.phpn.payment;


import com.phpn.order.sale.dto.PaymentOrderParam;
import com.phpn.order.sale.dto.PaymentSaleOrderResult;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PaymentOrderService {

    List<PaymentSaleOrderResult> findAll();

    @Transactional(readOnly = true)
    List<PaymentSaleOrderResult> findAllByOrderId(Integer orderId);

    PaymentSaleOrderResult createPaymentOrder(PaymentOrderParam paymentOrderParam);

}
