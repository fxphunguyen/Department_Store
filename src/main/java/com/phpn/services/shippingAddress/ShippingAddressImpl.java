package com.phpn.services.shippingAddress;


import com.phpn.dto.shipping_address.ShippingAddressResult;
import com.phpn.mappers.shippingAddress.ShippingAddressMapper;
import com.phpn.repositories.ShippingAddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShippingAddressImpl implements  ShippingAddressService{

    @Autowired
    ShippingAddressRepository shippingAddressRepository;


    @Autowired
    ShippingAddressMapper shippingAddressMapper;


    @Override
    public List<ShippingAddressResult> findByCustomerId(Integer id) {
        List<ShippingAddressResult> shippingAddresses = shippingAddressRepository.findAllShippingAddress(id)
                .stream()
                .map(shippingAddress -> shippingAddressMapper.toDTO(shippingAddress))
                .collect(Collectors.toList());
        return  shippingAddresses ;
    }

    @Override
    public ShippingAddressResult create() {
        return null;
    }
}
