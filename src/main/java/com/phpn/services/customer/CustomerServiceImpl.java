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
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
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
    private LocationRegionService locationRegionService;


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
        LocationRegion locationRegion = locationRegionMapper.toModel(customerCreate.getLocationRegionCreate());
        locationRegionRepository.save(locationRegion);
        LocationRegion idLocationRegionCr = locationRegionRepository.findMaxIdCustomer();
        customerCreate.setLocationRegionId(idLocationRegionCr.getId());

        return   customerRepository.save(customerMapper.toModel(customerCreate));
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
        Customer customer = customerRepository.findById(customerResult.getId()).get();
        System.out.println("---------------------- cútomer id");
        customerMapper.toCustomer(customerResult , customer);
        System.out.println(customer.getLocationRegion().getId());

//
//        LocationRegion locationRegion = locationRegionRepository.findById(customer.getLocationRegion().getId()).get();
//        locationRegionMapper.toLocationRegion(customerResult.getLocationRegionResult(), locationRegion);

//        locationRegion.setAddress(customerResult.getLocationRegionResult().getAddress());
//        locationRegion.setWardId(customerResult.getLocationRegionResult().getWardId());
//        locationRegion.setWardId(customerResult.getLocationRegionResult().getWardId());
//        locationRegion.setWardName(customerResult.getLocationRegionResult().getWardName());
//        locationRegion.setDistrictId(customerResult.getLocationRegionResult().getDistrictId());
//        locationRegion.setDistrictName(customerResult.getLocationRegionResult().getDistrictName());
//        locationRegion.setProvinceId(customerResult.getLocationRegionResult().getProvinceId());
//        locationRegion.setProvinceName(customerResult.getLocationRegionResult().getProvinceName());
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
