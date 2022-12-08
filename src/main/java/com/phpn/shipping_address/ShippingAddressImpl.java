package com.phpn.customer;


import vn.fx.qh.sapo.entities.ShippingAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShippingAddressImpl implements  ShippingAddressService{

    @Autowired
    ShippingAddressRepository shippingAddressRepository;


    @Autowired
    ICustomerMapper.ShippingAddressMapper shippingAddressMapper;


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
