
package com.phpn.payment;

import com.phpn.order.sale.dto.PaymentOrderParam;
import com.phpn.order.sale.dto.PaymentSaleOrderResult;
import com.phpn.exceptions.NotFoundException;
import com.phpn.employee.EmployeeRepository;
import com.phpn.order.SalesOrderRepository;
import vn.fx.qh.sapo.entities.PaymentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentOrderServiceImpl implements PaymentOrderService {

    @Autowired
    private PaymentOrderMapper paymentOrderMapper;

    @Autowired
    private PaymentOrderRepository paymentOrderRepository;

    @Autowired
    private SalesOrderRepository orderRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PaymentSaleOrderResult> findAll() {
        return paymentOrderRepository.findAll()
                .stream()
                .map(paymentOrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaymentSaleOrderResult> findAllByOrderId(Integer orderId) {
        return paymentOrderRepository.findAllByOrderId(orderId)
                .stream()
                .map(paymentOrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PaymentSaleOrderResult createPaymentOrder(PaymentOrderParam paymentOrderParam) {
        System.out.println(paymentOrderParam.getOrderId());
        Integer orderId = paymentOrderParam.getOrderId();
        if (orderId != null && !orderRepository.existsById(orderId))
            throw new NotFoundException("Khong tim thay order can thanh toan");
        PaymentOrder paymentInput = paymentOrderMapper.toModel(paymentOrderParam);
        paymentInput = paymentOrderRepository.save(paymentInput);

        return paymentOrderMapper.toDTO(paymentInput);
    }
}