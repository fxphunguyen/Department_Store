package com.phpn.services.customer;

import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.mappers.customer.CustomerMapper;
import com.phpn.repositories.CustomerRepository;
import com.phpn.repositories.LocationRegionRepository;
import com.phpn.repositories.model.Customer;
import com.phpn.services.locationRegion.LocationRegionService;
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
 public List<CustomerResult> findAllCustomer() {
  return customerRepository.findAllCustomer();
//          .stream()
//          .map(CustomerResult ->  customerMapper.toDTO(CustomerResult))
//          .collect(Collectors.toList());
 }

 @Override
 public void deleteCustomer(Long id) {
   customerRepository.deleteById(id);
 }



 @Override
 public ResponseEntity<?> createCustomer(Customer customer) {
   customerRepository.save(customer);
  return new ResponseEntity<>(HttpStatus.OK);
 }

 @Override
 public List<CustomerResult> findById(Integer id) {
  return  null;

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
  return null;
 }
}
