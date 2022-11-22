package com.phpn.services.customer;

import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.mappers.customer.CustomerMapper;
import com.phpn.mappers.localtionRegion.LocationRegionMapper;
import com.phpn.repositories.CustomerRepository;
import com.phpn.repositories.LocationRegionRepository;
import com.phpn.repositories.model.Customer;
import com.phpn.repositories.model.CustomerGender;
import com.phpn.repositories.model.LocationRegion;
import com.phpn.services.locationRegion.LocationRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    LocationRegionMapper locationRegionMapper;

    @Autowired
    LocationRegionRepository locationRegionRepository;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    LocationRegionService locationRegionService;


    @Override
    public void deleteCustomer(Integer id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void deleteStatusCustomer(Integer id) {
        Customer customer = customerRepository.findById(id).get();
        ;
        customer.setDeleted(true);
    }

    @Override
    public ResponseEntity<?> createCustomer(Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public CustomerResult findById(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerMapper.toDTO(customerOptional.get());
    }

    @Override
    public CustomerResult createCustomerResult(CustomerCreate customerCreate) {
        return customerMapper.toDTO(customerRepository.save(customerMapper.toModel(customerCreate)));
    }


    @Override
    public Customer create(CustomerCreate customerCreate) {
        System.out.println(customerCreate.getCustomerGender());
        System.out.println(customerCreate.getCustomerGroup());
        LocationRegion locationRegion = locationRegionMapper.toModel(customerCreate);
        locationRegionRepository.save(locationRegion);
        LocationRegion idLocationRegionCr = locationRegionRepository.findMaxIdCustomer();
        customerCreate.setLocationRegionID(idLocationRegionCr.getId());
        return customerRepository.save(customerMapper.toModel(customerCreate));
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

    @Override
    public Customer update(CustomerResult customerResult) {
        Customer customer = customerMapper.toCustomer(customerResult);
        System.out.println(customer.getLocationRegion().getId());
        LocationRegion locationRegion = locationRegionRepository.findById(customer.getLocationRegion().getId()).get();
        locationRegion.setAddress(customerResult.getLocationRegion().getAddress());
        locationRegion.setWardId(customerResult.getLocationRegion().getWardId());
        locationRegion.setWardId(customerResult.getLocationRegion().getWardId());
        locationRegion.setWardName(customerResult.getLocationRegion().getWardName());
        locationRegion.setDistrictId(customerResult.getLocationRegion().getDistrictId());
        locationRegion.setDistrictName(customerResult.getLocationRegion().getDistrictName());
        locationRegion.setProvinceId(customerResult.getLocationRegion().getProvinceId());
        locationRegion.setProvinceName(customerResult.getLocationRegion().getProvinceName());
        return customer;
    }

    @Override

    public CustomerGender[] findAllByCustomerGender() {
        CustomerGender[] customerGender = CustomerGender.values();
        return customerGender;
    }

    @Override
    public List<CustomerResult> findAllCustomerByDelete(boolean deleted) {
        return null;
    }

}
