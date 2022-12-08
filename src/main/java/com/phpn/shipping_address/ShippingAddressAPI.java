package com.phpn.shipping_address;


import com.phpn.customer.dto.CreateShippingAddressParam;
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
        List<ShippingAddressShowCustomerInfo> shippingAddresses = shippingAddressService.findByCustomerId(id);
        return  new ResponseEntity<>(shippingAddresses, HttpStatus.OK) ;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createShippingAddress(@RequestBody CreateShippingAddressParam createShippingAddressParam ){
        ShippingAddress shippingAddress = shippingAddressService.create(createShippingAddressParam);
        return  new ResponseEntity<>(shippingAddress, HttpStatus.OK) ;
    }
}
