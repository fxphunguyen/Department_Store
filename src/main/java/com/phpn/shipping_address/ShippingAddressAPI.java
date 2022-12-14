package com.phpn.shipping_address;


import com.phpn.customer.dto.CreateShippingAddressParam;
import com.phpn.shipping_address.dto.ShippingAddressResult;
import com.phpn.shipping_address.dto.ShippingAddressShowCustomerInfo;
import com.phpn.shipping_address.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import vn.fx.qh.sapo.entities.customer.ShippingAddress;

import java.util.List;

@RestController
@RequestMapping("/api/shippingAddress")
public class ShippingAddressAPI {

    @Autowired
    ShippingAddressService shippingAddressService;

    @Autowired
    ShippingAddressRepository shippingAddressRepository;

    @GetMapping("/findByCustomerId/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> findShippingAddress(@PathVariable Integer id){
        List<ShippingAddressResult> shippingAddresses = shippingAddressService.findByCustomerId(id);
        return  new ResponseEntity<>(shippingAddresses, HttpStatus.OK) ;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createShippingAddress(@RequestBody CreateShippingAddressParam createShippingAddressParam ){
        ShippingAddressResult shippingAddressResult = shippingAddressService.create(createShippingAddressParam);
        return  new ResponseEntity<>(shippingAddressResult, HttpStatus.OK) ;
    }
}
