package com.phpn.services.customer;

import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.mappers.customer.CustomerMapper;
import com.phpn.repositories.CustomerRepository;
import com.phpn.repositories.LocationRegionRepository;
import com.phpn.repositories.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    LocationRegionRepository locationRegionRepository;

    @Autowired
    CustomerMapper customerMapper;

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public void deleteCustomer(Integer id) {

    }

    @Override
    public ResponseEntity<?> createCustomer(Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public List<CustomerResult> findById(Integer id) {
        return null;

    }

    @Override
    public CustomerResult createCustomerResult(CustomerCreate customerCreate) {
        return null;
    }


    @Override
    public CustomerResult create(CustomerCreate customerCreate) {
        return customerMapper.toDTO(customerRepository.save(customerMapper.toModel(customerCreate)));
    }

    @Override
    public List<CustomerResult> findCustomerByDeleted(boolean deleted) {
        return customerRepository.findCustomerByDeleted(deleted);
    }

    @Override
    public List<CustomerResult> findAllCustomerResultByDeleted(boolean deleted) {
        return customerRepository.findAllCustomerResultByDeleted(deleted)
                .stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CustomerResult> findAll() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> customerMapper.toDTO(customer))
                .collect(Collectors.toList());
    }

}
