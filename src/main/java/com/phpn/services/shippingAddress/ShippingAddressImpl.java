package com.phpn.services.shippingAddress;


import com.phpn.dto.shipping_address.CreateShippingAddressParam;
import com.phpn.dto.shipping_address.ShippingAddressResult;
import com.phpn.dto.shipping_address.ShippingAddressShowCustomerInfo;
import com.phpn.mappers.shippingAddress.ShippingAddressMapper;
import com.phpn.repositories.ShippingAddressRepository;
import com.phpn.repositories.model.ShippingAddress;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShippingAddressImpl implements  ShippingAddressService{

    @Autowired
    ShippingAddressRepository shippingAddressRepository;


    @Autowired
    ShippingAddressMapper shippingAddressMapper;


    @Override
    public List<ShippingAddressShowCustomerInfo> findByCustomerId(Integer id) {
        List<ShippingAddressShowCustomerInfo> shippingAddressShowCustomerInfos = shippingAddressRepository.findAllShippingAddress(id)
                .stream()
                .map(shippingAddress -> shippingAddressMapper.toCustomerInfo(shippingAddress))
                .collect(Collectors.toList());
        return  shippingAddressShowCustomerInfos ;
    }

    @Override
    public ShippingAddress create(CreateShippingAddressParam createShippingAddressParam) {
//
//        ShippingAddress shippingAddress = shippingAddressRepository.save(shippingAddressMapper.toModel(createShippingAddressParam));
        return  shippingAddressRepository.save(shippingAddressMapper.toModel(createShippingAddressParam));
    }
}
