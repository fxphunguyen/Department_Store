package com.phpn.customer.service;

import com.phpn.customer.CustomerMapper;
import com.phpn.customer.CustomerRepository;
import com.phpn.customer.customerDebt.CustomerDebt;
import com.phpn.customer.customerDebt.CustomerDebtImpl;
import com.phpn.customer.dto.CustomerResult;
import com.phpn.customer.dto.UpdateCustomerParam;
import com.phpn.customer.dto.CreateCustomerParam;
import com.phpn.customer.dto.CreateShippingAddressParam;
import com.phpn.exceptions.AppNotFoundException;
import com.phpn.exceptions.DataInputException;
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
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;


@Service
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
        BigDecimal spendTotal = saleOrderService.getSpendTotalByCustomerId(customer.getId());
        if (spendTotal == null) {
            spendTotal = BigDecimal.valueOf(0);
        }
//        BigDecimal paidTotal = paymentSaleOrderService.getPaidTotalByCustomerId(customer.getId());
//        if (paidTotal == null) {
//            paidTotal = BigDecimal.valueOf(0);
//        }
        BigDecimal debtTotal = paymentSaleOrderService.getDebtTotalByCustomerId(customer.getId());
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

        Instant lastDayOrder = saleOrderService.getLastDayOrderByCustomerId(customerResult.getId());

        customerResult.setLastDayOrder(lastDayOrder);

        return customerResult;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerResult> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> {
                    CustomerResult dto = customerMapper.toDTO(customer);
                    BigDecimal spendTotal = saleOrderService.getSpendTotalByCustomerId(customer.getId());
                    if (spendTotal == null)
                        spendTotal = BigDecimal.valueOf(0);

                    BigDecimal paidTotal = paymentSaleOrderService.getPaidTotalByCustomerId(customer.getId());
                    if (paidTotal == null)
                        paidTotal = BigDecimal.valueOf(0);
                    dto.setSpendTotal(spendTotal);
                    dto.setDebtTotal(spendTotal.subtract(paidTotal));
                    return dto;
                }).collect(Collectors.toList());
    }


    @Override
    @Transactional(readOnly = true)
    public List<CustomerResult> findCustomerByStatus() {
        return customerRepository.findCustomersByCustomerStatus()
                .stream()
                .map(customer -> {
                    CustomerResult dto = customerMapper.toDTO(customer);
                    BigDecimal spendTotal = saleOrderService.getSpendTotalByCustomerId(customer.getId());
                    if (spendTotal == null)
                        spendTotal = BigDecimal.valueOf(0);

                    BigDecimal debtTotal = paymentSaleOrderService.getDebtTotalByCustomerId(customer.getId());
                    if (debtTotal == null)
                        debtTotal = BigDecimal.valueOf(0);
                    dto.setSpendTotal(spendTotal);
                    dto.setDebtTotal(debtTotal);
                    return dto;
                }).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CustomerResult create(CreateCustomerParam customerCreate) {
        if (customerCreate.getName().equals("")) {
            throw new DataInputException("T??n kh??ch h??ng l?? b???t bu???c");
        }

        if (customerCreate.getEmployeeId() == null) {
            throw new DataInputException("B???n ch??a ch???n nh??n vi??n ph??? tr??ch");
        }
        try {
            Customer customer = customerRepository.save(customerMapper.toCustomer(customerCreate));
            customer.setCustomerCode("CUZN" + customer.getId());
            CreateShippingAddressParam shippingAddressParam = customerCreate.getCreateShippingAddressParam();

            shippingAddressParam.setCustomerId(customer.getId());
            shippingAddressParam.setIsShipping(true);
            shippingAddressParam.setIsReceiveBill(true);
            shippingAddressService.create(customerCreate.getCreateShippingAddressParam());

            return customerMapper.toCustomerInfo(customer);

        } catch (Exception e) {
            throw new DataInputException("L???i kh??ng x??c ?????nh");
        }
    }

    @Override
    @Transactional
    public CustomerResult update(UpdateCustomerParam updateCustomer) {
        if (updateCustomer.getName().equals("")) {
            throw new DataInputException("T??n kh??ch h??ng l?? b???t bu???c");
        }
        if (updateCustomer.getCustomerCode().equals("")) {
            throw new DataInputException("M?? kh??ch h??ng kh??ng ???????c ????? tr???ng");
        }
        if (updateCustomer.getEmployeeId() == null) {
            throw new DataInputException("B???n ch??a ch???n nh??n vi??n ph??? tr??ch");
        }
        try {
            Customer customer = customerRepository.findById(updateCustomer.getId()).get();
            Customer customer1 = customerMapper.toCustomer(updateCustomer, customer);
            return  customerMapper.toDTO(customer1);

        } catch (Exception e) {
            throw new DataInputException("L???i kh??ng x??c ?????nh");
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<SaleOrderResult> findHistoryCustomerOrder(Integer id) {
        List<SaleOrderResult> saleOrderByCustomer = saleOrderService.findAllSaleOrderByCustomerId(id);
        return saleOrderByCustomer;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDebtImpl> findCustomerDebtsByCustomerId(Integer customerId) {
        List<CustomerDebt> customerDebts = customerRepository.findCustomerDebtsByCustomerId(customerId);

        List<CustomerDebtImpl> customerDebts1 = customerDebts.stream().map(customerDebt -> {
            CustomerDebtImpl customerDebtImpl = new CustomerDebtImpl();
            customerDebtImpl.setFromICustomerOwer(customerDebt);
            return customerDebtImpl;
        }).collect(Collectors.toList());
        BigDecimal tam = BigDecimal.valueOf(0);
        for (CustomerDebtImpl customerDebtImpl : customerDebts1) {
            tam = tam.add(customerDebtImpl.getTransaction());
            customerDebtImpl.setTotalDebt(tam);
            System.out.println(customerDebtImpl.getTransaction());
        }
        return customerDebts1;
    }

    @Override
    public void delete(Integer customerId) {
        Customer customer = customerRepository.findById(customerId).get();
        try {
            shippingAddressService.delete(customer.getShippingAddress().getId());
            customerRepository.deleteById(customerId);
        } catch (Exception e) {
            throw new DataInputException("L???i kh??ng x??c ?????nh");
        }

    }

}
