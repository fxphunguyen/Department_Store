package com.phpn.customer.service;

import com.phpn.customer.CustomerMapper;
import com.phpn.customer.CustomerRepository;
import com.phpn.customer.dto.CustomerResult;
import com.phpn.customer.UpdateCustomerParam;
import com.phpn.customer.dto.CreateCustomerParam;
import com.phpn.customer.dto.CreateShippingAddressParam;
import com.phpn.order.sale.SaleOrderService;
import com.phpn.order.sale.dto.SaleOrderResult;
import com.phpn.order.sale.item.OrderItemService;
import com.phpn.payment.purchase.PaymentSaleOrderService;
import com.phpn.shipping_address.service.ShippingAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.fx.qh.sapo.entities.customer.Customer;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    PaymentSaleOrderService paymentSaleOrderService;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ShippingAddressService shippingAddressService;
    @Autowired
    SaleOrderService saleOrderService;


    @Override
    @Transactional(readOnly = true)
    public CustomerResult findById(Integer id) {
        Customer customer = customerRepository.findById(id).get();
        CustomerResult customerResult = customerMapper.toCustomerInfo(customer);
        BigDecimal spendTotal = saleOrderService.getSpendTotal(customer.getId());
        if (spendTotal == null) {
            spendTotal = BigDecimal.valueOf(0);
        }
        BigDecimal paidTotal = paymentSaleOrderService.getSpendTotalByCustomerId(customer.getId());
        if (paidTotal == null) {
            paidTotal = BigDecimal.valueOf(0);
        }
        BigDecimal debtTotal = spendTotal.subtract(paidTotal);
        customerResult.setSpendTotal(spendTotal);
        customerResult.setDebtTotal(debtTotal);
        Integer quantityProductOrder = saleOrderService.getQuantityProductOrder(customerResult.getId());
        if (quantityProductOrder == null) {
            quantityProductOrder = 0;
        }
        customerResult.setQuantityProductOrder(quantityProductOrder);
        Integer quantityItemOrder = orderItemService.getQuantityItemCustomerOrderById(customerResult.getId());
        if (quantityItemOrder == null) {
            quantityItemOrder = 0;
        }
        customerResult.setQuantityItemOrder(quantityItemOrder);

        return customerResult;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerResult> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> {
                    CustomerResult dto = customerMapper.toDTO(customer);
                    BigDecimal spendTotal = saleOrderService.getSpendTotal(customer.getId());
                    if (spendTotal == null) {
                        spendTotal = BigDecimal.valueOf(0);
                    }
                    BigDecimal paidTotal = paymentSaleOrderService.getSpendTotalByCustomerId(customer.getId());
                    if (paidTotal == null) {
                        paidTotal = BigDecimal.valueOf(0);
                    }
                    BigDecimal debtTotal = spendTotal.subtract(paidTotal);
                    dto.setSpendTotal(spendTotal);
                    dto.setDebtTotal(debtTotal);
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    public CustomerResult create(CreateCustomerParam customerCreate) {
        Customer customer = customerRepository.save(customerMapper.toCustomer(customerCreate));
        CreateShippingAddressParam shippingAddressParam = customerCreate.getCreateShippingAddressParam();
        shippingAddressParam.setCustomerId(customer.getId());
        shippingAddressService.create(customerCreate.getCreateShippingAddressParam());
        return customerMapper.toCustomerInfo(customer);
    }

    @Override
    public CustomerResult update(UpdateCustomerParam updateCustomer) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<SaleOrderResult> findHistoryCustomerOrder(Integer id) {
        List<SaleOrderResult> saleOrderByCustomer = saleOrderService.findAllSaleOrderByCustomer(id);
        return saleOrderByCustomer;
    }

}
