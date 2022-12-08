package com.phpn.payment.purchase;

import com.phpn.employee.dto.EmployeeMapper;
import com.phpn.order.sale.dto.PaymentOrderParam;
import com.phpn.order.sale.dto.PaymentSaleOrderResult;
import com.phpn.order.sale.dto.SaleOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.fx.qh.sapo.entities.payment.sale.PaymentSaleOrder;
import vn.fx.qh.sapo.entities.payment.sale.PaymentSalesOrder;

import java.time.Instant;

@Component
public class PaymentSaleOrderMapper {

    @Autowired
    private SaleOrderMapper orderMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    public PaymentSaleOrderResult toDTO(PaymentSaleOrder paymentOrder) {
        return new PaymentSaleOrderResult()
                .setId(paymentOrder.getId())
                .setPaid(paymentOrder.getPaid())
                .setCreateAt(paymentOrder.getCreateAt())
                .setOrderResult(orderMapper.toDTO(paymentOrder.getOrder()))
                .setEmployeeResult(employeeMapper.toDTO(paymentOrder.getEmployee()))
                .setDescription(paymentOrder.getDescription());
    }

    public PaymentSaleOrderResult toOrderInfo(PaymentSalesOrder paymentOrder) {
        return new PaymentSaleOrderResult()
                .setId(paymentOrder.getId())
                .setPaid(paymentOrder.getPaid())
                .setCreateAt(paymentOrder.getCreateAt())
                .setDescription(paymentOrder.getDescription());
    }

    public PaymentSalesOrder toModel(PaymentOrderParam paymentOrderParam) {
        return new PaymentSalesOrder()
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
