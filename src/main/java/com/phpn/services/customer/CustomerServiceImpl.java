package com.phpn.services.customer;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

<<<<<<< HEAD
=======
 @Autowired
 LocationRegionRepository locationRegionRepository;

 @Autowired
 CustomerMapper customerMapper;

 @Autowired
 CustomerRepository customerRepository;


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

 @Override
 public List<CustomerResult> findAllCustomerResultByDeleted(boolean deleted) {
  return null;
 }
>>>>>>> 9120c2af7e0c652f7a1143329c5de45d202f1f34
}
