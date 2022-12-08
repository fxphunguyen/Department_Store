package com.phpn.mappers.payment;

import com.phpn.dto.paymentOrder.PaymentOrderParam;
import com.phpn.dto.paymentOrder.PaymentOrderResult;
import com.phpn.mappers.customer.CustomerMapper;
import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.mappers.order.OrderMapper;
import com.phpn.repositories.model.PaymentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;

@Component
public class PaymentOrderMapper {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public PaymentOrderResult toDTO(PaymentOrder paymentOrder) {
        return new PaymentOrderResult()
                .setId(paymentOrder.getId())
                .setPaid(paymentOrder.getPaid())
                .setCreateAt(paymentOrder.getCreateAt())
                .setOrderResult(orderMapper.toDTO(paymentOrder.getOrder()))
                .setEmployeeResult(employeeMapper.toDTO(paymentOrder.getEmployee()))
                .setDescription(paymentOrder.getDescription());
    }

    public PaymentOrderResult toOrderInfo(PaymentOrder paymentOrder) {
        return new PaymentOrderResult()
                .setId(paymentOrder.getId())
                .setPaid(paymentOrder.getPaid())
                .setCreateAt(paymentOrder.getCreateAt())
                .setDescription(paymentOrder.getDescription());
    }

    public PaymentOrder toModel(PaymentOrderParam paymentOrderParam) {
        return new PaymentOrder()
                .setId(0)
                .setPaid(paymentOrderParam.getPaid())
                .setCreateAt(Instant.now().toString())
                .setOrderId(paymentOrderParam.getOrderId())
                .setCustomerId(paymentOrderParam.getCustomerId())
                .setEmployeeId(paymentOrderParam.getEmployeeId())
                .setPaymentMethodId(paymentOrderParam.getPaymentMethodId())
                .setDescription(paymentOrderParam.getDescription());
    }
}
