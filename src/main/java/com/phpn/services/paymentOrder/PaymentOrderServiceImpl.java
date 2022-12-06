
package com.phpn.services.paymentOrder;

import com.phpn.dto.paymentOrder.PaymentOrderParam;
import com.phpn.dto.paymentOrder.PaymentOrderResult;
import com.phpn.exceptions.NotFoundException;
import com.phpn.mappers.payment.PaymentOrderMapper;
import com.phpn.repositories.EmployeeRepository;
import com.phpn.repositories.OrderRepository;
import com.phpn.repositories.PaymentOrderRepository;
import com.phpn.repositories.model.PaymentOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentOrderServiceImpl implements PaymentOrderService {

    @Autowired
    private PaymentOrderMapper paymentOrderMapper;

    @Autowired
    private PaymentOrderRepository paymentOrderRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PaymentOrderResult> findAll() {
        return paymentOrderRepository.findAll()
                .stream()
                .map(paymentOrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PaymentOrderResult> findAllByOrderId(Integer orderId) {
        return paymentOrderRepository.findAllByOrderId(orderId)
                .stream()
                .map(paymentOrderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public PaymentOrderResult createPaymentOrder(PaymentOrderParam paymentOrderParam) {
        System.out.println(paymentOrderParam.getOrderId());
        Integer orderId = paymentOrderParam.getOrderId();
        if (orderId != null && !orderRepository.existsById(orderId))
            throw new NotFoundException("Khong tim thay order can thanh toan");
        PaymentOrder paymentInput = paymentOrderMapper.toModel(paymentOrderParam);
        paymentInput = paymentOrderRepository.save(paymentInput);

        return paymentOrderMapper.toDTO(paymentInput);
    }
}