package com.phpn.controllers.api;


import com.phpn.dto.shipping_address.CreateShippingAddressParam;
import com.phpn.dto.shipping_address.ShippingAddressResult;
import com.phpn.dto.shipping_address.ShippingAddressShowCustomerInfo;
import com.phpn.mappers.shippingAddress.ShippingAddressMapper;
import com.phpn.repositories.ShippingAddressRepository;
import com.phpn.repositories.model.ShippingAddress;
import com.phpn.services.shippingAddress.ShippingAddressService;
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
    ShippingAddressMapper shippingAddressMapper;

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