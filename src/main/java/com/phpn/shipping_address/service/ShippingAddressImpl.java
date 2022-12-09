package com.phpn.shipping_address.service;


import com.phpn.customer.ShippingAddressMapper;
import com.phpn.customer.dto.CreateShippingAddressParam;
import com.phpn.shipping_address.ShippingAddressRepository;
import com.phpn.shipping_address.dto.ShippingAddressShowCustomerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fx.qh.sapo.entities.customer.ShippingAddress;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShippingAddressImpl implements ShippingAddressService {

    @Autowired
    ShippingAddressRepository shippingAddressRepository;

    @Autowired
    ShippingAddressMapper shippingAddressMapper;


    @Override
    public List<ShippingAddressShowCustomerInfo> findByCustomerId(Integer id) {
        return shippingAddressRepository.findAllShippingAddress(id)
                .stream()
                .map(shippingAddress -> shippingAddressMapper.toCustomerInfo(shippingAddress))
                .collect(Collectors.toList());
    }

    @Override
    public ShippingAddress create(CreateShippingAddressParam createShippingAddressParam) {
        return shippingAddressRepository.save(shippingAddressMapper.toModel(createShippingAddressParam));
    }
}
