package com.phpn.controllers.api;


import com.phpn.dto.shipping_address.ShippingAddressResult;
import com.phpn.mappers.shippingAddress.ShippingAddressMapper;
import com.phpn.repositories.ShippingAddressRepository;
import com.phpn.repositories.model.ShippingAddress;
import com.phpn.services.shippingAddress.ShippingAddressService;
import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/shippingAddress")
public class ShippingAddressAPI {

    @Autowired
    ShippingAddressService shippingAddressService;

    @GetMapping("/findByCustomerId/{id}")
    @Transactional(readOnly = true)
    public ResponseEntity<?> findShippingAddress(@PathVariable Integer id){
        List<ShippingAddressResult> shippingAddresses = shippingAddressService.findByCustomerId(id);
        return  new ResponseEntity<>(shippingAddresses, HttpStatus.OK) ;
    }
}
