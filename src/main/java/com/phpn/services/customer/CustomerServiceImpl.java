package com.phpn.services.customer;

import com.phpn.dto.customer.CreateCustomerParam;
import com.phpn.dto.customer.CustomerOrderResult;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.dto.shipping_address.CreateShippingAddressParam;
import com.phpn.mappers.customer.CustomerMapper;
import com.phpn.mappers.customer.ShippingAddressMapper;
import com.phpn.repositories.CustomerRepository;

import com.phpn.repositories.ShippingAddressRepository;
import com.phpn.repositories.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    private ShippingAddressMapper shippingAddressMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ShippingAddressRepository shippingAddressRepository;




    @Override
    @Transactional(readOnly = true)
    public CustomerResult findById(Integer id) {
        System.out.println(id + "dday laf id");
        Customer customer = customerRepository.findById(id).get();
        if (customer == null) {
            System.out.println("duwx lieeuj bij nu");
        }
        return customerMapper.toDTO(customerRepository.findById(id).get());
    }

    public CustomerOrderResult findByIdCustomerOrder(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerMapper.toOrderDTO(customerOptional.get());
    }

    @Override
    @Transactional
    public CustomerResult create(CreateCustomerParam customerCreate) {

        Customer customer = customerRepository.save(customerMapper.toModel(customerCreate));
        CreateShippingAddressParam shippingAddressParam = customerCreate.getShippingAddress();
        shippingAddressParam.setCustomerId(customer.getId());
        ShippingAddress shippingAddress = shippingAddressMapper.toModel(shippingAddressParam);
        shippingAddressRepository.save(shippingAddress);
        return customerMapper.toDTO(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerResult> findCustomerByDeleted(boolean deleted) {
        return null;
    }

    @Override
    public List<CustomerOrderResult> findAllCustomerResultByDeleted(boolean deleted) {
        return null;
    }


    @Override
    @Transactional(readOnly = true)
    public List<CustomerResult> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> customerMapper.toDTO(customer))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public CustomerResult update(CustomerResult customerResult) {
        Customer customer = customerRepository.findById(customerResult.getId()).get();
        customerMapper.toCustomer(customerResult, customer);
        return customerMapper.toDTO(customer);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerGender[] findAllByCustomerGender() {
        CustomerGender[] customerGender = CustomerGender.values();
        return customerGender;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerResult> findAllCustomerByDelete(boolean deleted) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ICustomer> showAllCustomerMixInfoByStatus() {
        return customerRepository.getAllCustomerMixInfoByStatus();
    }

    @Override
    @Transactional(readOnly = true)
    public List<ICustomer> showAllCustomerMixInfo() {
        return customerRepository.getAllCustomerMixInfo();
    }

    @Override
    @Transactional(readOnly = true)
    public ICustomer CustomerInfoById(Integer id) {
        return customerRepository.getCustomerInfoById(id);
    }

    @Override
    public List<ICustomerOwerImpl> CustomerOwerById(Integer id) {
        List<ICustomerOwer> iCustomerOwers = customerRepository.getCustomerOwerById(id);
        List<ICustomerOwerImpl> iCustomerImpls = iCustomerOwers.stream().map(iCustomerOwer -> {
            ICustomerOwerImpl iCustomerOwerImpl = new ICustomerOwerImpl();
            iCustomerOwerImpl.setFromICustomerOwer(iCustomerOwer);
            System.out.println("đay là total" + iCustomerOwerImpl.getTotal_transaction());
            return iCustomerOwerImpl;
        }).collect(Collectors.toList());
        BigDecimal tam = BigDecimal.valueOf(0);
        for (ICustomerOwerImpl customerOwer : iCustomerImpls){
            tam = tam.add(customerOwer.getTransaction());
            customerOwer.setTotal_transaction(tam) ;
            System.out.println(customerOwer.getTransaction());
        }
        return  iCustomerImpls;
    }

    @Override
    public List<CustomerResult> findAllCustomer() {
        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

}
