package com.phpn.customer;

import com.phpn.exceptions.NotFoundException;
import com.phpn.shipping_address.ShippingAddressRepository;
import com.phpn.shipping_address.ShippingAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.fx.qh.sapo.entities.customer.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private ShippingAddressService shippingAddressService;


    @Override
    @Transactional(readOnly = true)
    public CustomerResult findById(Integer id) {
        Optional<Customer> customerOpt = customerRepository.findById(id);
        if (!customerOpt.isPresent()) throw new NotFoundException("Customer not found");
        return customerMapper.toDTO(customerOpt.get());
    }

    @Override
    public List<CustomerResult> findAll() {
        return customerRepository.findAll().stream().map(customerMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CustomerResult create(CreateCustomerParam customerCreate) {
        Customer customer = customerRepository.save(customerMapper.toCustomer(customerCreate));
        CreateShippingAddressParam shippingAddressParam = customerCreate.getCreateShippingAddressParam();
        shippingAddressParam.setCustomerId(customer.getId());
        shippingAddressService.create(customerCreate.getCreateShippingAddressParam());
        return customerMapper.toDTO(customer);
    }

    @Override
    public CustomerResult update(UpdateCustomerParam updateCustomer) {
        return null;
    }
}
