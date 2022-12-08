package com.phpn.payment.purchase;


import com.phpn.payment.sale.PaymentOrderParam;
import com.phpn.payment.sale.PaymentSaleOrderResult;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

public interface PaymentSaleOrderService {

    List<PaymentSaleOrderResult> findAll();

    @Transactional(readOnly = true)
    List<PaymentSaleOrderResult> findAllByOrderId(Integer orderId);

    PaymentSaleOrderResult createPaymentOrder(PaymentOrderParam paymentOrderParam);

    BigDecimal getSpendTotalByCustomerId(Integer id);

}
