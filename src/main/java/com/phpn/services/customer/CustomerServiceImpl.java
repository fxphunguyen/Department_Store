package com.phpn.services.customer;

import com.phpn.dto.customer.CustomerCreate;
import com.phpn.dto.customer.CustomerOrderResult;
import com.phpn.dto.customer.CustomerParam;
import com.phpn.dto.customer.CustomerResult;
import com.phpn.mappers.customer.CustomerMapper;
import com.phpn.mappers.localtionRegion.LocationRegionMapper;
import com.phpn.repositories.CustomerRepository;
import com.phpn.repositories.LocationRegionRepository;
import com.phpn.repositories.model.*;
import com.phpn.services.locationRegion.LocationRegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
    public void deleteStatusCustomer(Integer id) {
        Customer customer = customerRepository.findById(id).get();
        customer.setDeleted(true);
    }

    @Override
    @Transactional(readOnly = true)
    public CustomerResult findById(Integer id) {
        System.out.println(id + "dday laf id");
        Customer customer = customerRepository.findById(id).get();
        if(customer == null){
            System.out.println("duwx lieeuj bij nu");
        }
        return customerMapper.toDTO(customerRepository.findById(id).get());
    }

    public CustomerOrderResult findByIdCustomerOrder(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        return customerMapper.toOrderDTO(customerOptional.get());
    }

<<<<<<< HEAD


=======
    @Override
    public Customer createCustomerResult(CustomerParam customerParam) {
        return null;
    }
>>>>>>> 3b66ad51328ce8e461613c0e16cc121d6712cdb6


    @Override
    public Customer create(CustomerCreate customerCreate) {
        LocationRegion locationRegion = locationRegionMapper.toModel(customerCreate.getLocationRegionCreate());
        locationRegionRepository.save(locationRegion);
        LocationRegion idLocationRegionCr = locationRegionRepository.findMaxIdCustomer();
        customerCreate.setLocationRegionId(idLocationRegionCr.getId());

        return   customerRepository.save(customerMapper.toModel(customerCreate));
    }
    @Override
<<<<<<< HEAD
    public List<CustomerResult> findAllCustomerResultByDeleted(boolean deleted) {
=======
    public List<CustomerResult> findCustomerByDeleted(boolean deleted) {
        return null;
    }

    @Override
    public List<CustomerOrderResult> findAllCustomerResultByDeleted(boolean deleted) {
>>>>>>> 3b66ad51328ce8e461613c0e16cc121d6712cdb6
        return customerRepository.findAllCustomerResultByDeleted(deleted)
                .stream()
                .map(customerMapper::toOrderDTO)
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
        customerMapper.toCustomer(customerResult , customer);
        return customer;
    }


    @Override
    public List<CustomerResult> findAllCustomerByDelete(boolean deleted) {
        return null;
    }

    @Override
    public List<ICustomer>  showAllCustomerMixInfoByStatus() {
        return customerRepository.getAllCustomerMixInfoByStatus();
    }

    @Override
    public List<ICustomer> showAllCustomerMixInfo() {
        return customerRepository.getAllCustomerMixInfo();
    }

    @Override
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
