package com.phpn.customer;


import com.phpn.customer.CreateShippingAddressParam;
import com.phpn.customer.ShippingAddressShowCustomerInfo;
import com.phpn.customer.ICustomerMapper;
import com.phpn.customer.ShippingAddressRepository;
import vn.fx.qh.sapo.entities.ShippingAddress;
import com.phpn.customer.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shippingAddress")
public class ShippingAddressAPI {

    @Autowired
    ShippingAddressService shippingAddressService;

    @Autowired
    ShippingAddressRepository shippingAddressRepository;

    @Autowired
    ICustomerMapper.ShippingAddressMapper shippingAddressMapper;

    @GetMapping("/findByCustomerId/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> findShippingAddress(@PathVariable Integer id){
        List<ShippingAddressShowCustomerInfo> shippingAddresses = shippingAddressService.findByCustomerId(id);
        return  new ResponseEntity<>(shippingAddresses, HttpStatus.OK) ;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createShippingAddress(@RequestBody CreateShippingAddressParam createShippingAddressParam ){
        ShippingAddress shippingAddress = shippingAddressService.create(createShippingAddressParam);
        return  new ResponseEntity<>(shippingAddress, HttpStatus.OK) ;
    }
}
