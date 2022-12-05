package com.phpn.controllers.api;


import com.phpn.dto.shipping_address.CreateShippingAddressParam;
import com.phpn.dto.shipping_address.ShippingAddressResult;
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
        List<ShippingAddressResult> shippingAddresses = shippingAddressService.findByCustomerId(id);
        return  new ResponseEntity<>(shippingAddresses, HttpStatus.OK) ;
    }

    @PostMapping("/create")
    @Transactional(readOnly = true)
    public ResponseEntity<?> createShippingAddress(@RequestBody CreateShippingAddressParam createShippingAddressParam ){
        System.out.println(createShippingAddressParam.getAddress());
        System.out.println(createShippingAddressParam);
        ShippingAddressResult shippingAddressResult = shippingAddressService.create(createShippingAddressParam);
        return  new ResponseEntity<>(shippingAddressResult, HttpStatus.OK) ;
    }

}
