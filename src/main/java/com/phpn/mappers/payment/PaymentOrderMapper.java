package com.phpn.mappers.payment;

import com.phpn.dto.paymentOrder.PaymentOrderParam;
import com.phpn.dto.paymentOrder.PaymentOrderResult;
import com.phpn.mappers.customer.CustomerMapper;
import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.mappers.order.OrderMapper;
import com.phpn.repositories.model.PaymentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public PaymentOrder toModel(PaymentOrderParam paymentOrderParam) {
        return new PaymentOrder()
                .setId(paymentOrderParam.getId())
                .setPaid(paymentOrderParam.getPaid())
                .setCreateAt(paymentOrderParam.getCreateAt())
                .setOrderId(paymentOrderParam.getOrderId())
                .setEmployeeId(paymentOrderParam.getEmployeeId())
                .setDescription(paymentOrderParam.getDescription());
    }
}
