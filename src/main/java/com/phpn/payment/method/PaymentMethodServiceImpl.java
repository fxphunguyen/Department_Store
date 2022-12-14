package com.phpn.payment.method;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.phpn.exceptions.NotFoundException;
import com.phpn.order.PaymentMethodResult;
import vn.fx.qh.sapo.entities.payment.*;

@Service
@Transactional
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private PaymentMethodMapper paymentMethodMapper;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Override
    @Transactional(readOnly = true)
    public List<PaymentMethodResult> findAll() {
        List<PaymentMethodResult> paymentMethodResultList = paymentMethodRepository
        .findAll()
        .stream()
        .map(paymentMethod -> paymentMethodMapper.toDTO(paymentMethod))
        .collect(Collectors.toList());

        if (paymentMethodResultList.isEmpty()) throw new NotFoundException("Not found payment method data or is empty!");
        return paymentMethodResultList;
    }

    @Override
    @Transactional(readOnly = true)
    public PaymentMethodResult findById(Integer id) {
        Optional<PaymentMethod> paymentMethodOptional = paymentMethodRepository.findById(id);
        if (!paymentMethodOptional.isPresent()) throw new NotFoundException("Not found payment method with id: " + id);
        return paymentMethodMapper.toDTO(paymentMethodOptional.get());
    }

}