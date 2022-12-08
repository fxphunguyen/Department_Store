
package com.phpn.payment.purchase;

import com.phpn.payment.sale.PaymentOrderParam;
import com.phpn.payment.sale.PaymentSaleOrderResult;
import com.phpn.exceptions.NotFoundException;
import com.phpn.employee.EmployeeRepository;
import com.phpn.order.sale.SaleOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.fx.qh.sapo.entities.payment.sale.PaymentSaleOrder;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentSaleOrderServiceImpl implements PaymentSaleOrderService {

    @Autowired
    private PaymentSaleOrderMapper paymentOrderMapper;

    @Autowired
    private PaymentOrderRepository paymentOrderRepository;

    @Autowired
    private SaleOrderRepository orderRepository;

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
        PaymentSaleOrder paymentInput = paymentOrderMapper.toModel(paymentOrderParam);
        paymentInput = paymentOrderRepository.save(paymentInput);

        return paymentOrderMapper.toDTO(paymentInput);
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal getSpendTotalByCustomerId(Integer id) {
        return paymentOrderRepository.getPaidTotalByCustomerById(id);
    }
}