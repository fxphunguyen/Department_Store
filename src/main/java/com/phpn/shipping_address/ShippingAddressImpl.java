package com.phpn.shipping_address;


import com.phpn.customer.CreateShippingAddressParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.fx.qh.sapo.entities.customer.ShippingAddress;

import java.util.List;

@Service
public class ShippingAddressImpl implements ShippingAddressService {

    @Autowired
    ShippingAddressRepository shippingAddressRepository;


    @Override
    public List<ShippingAddressShowCustomerInfo> findByCustomerId(Integer id) {
//        List<ShippingAddressShowCustomerInfo> shippingAddressShowCustomerInfos = shippingAddressRepository.findAllShippingAddress(id)
//                .stream()
//                .map(shippingAddress -> shippingAddressMapper.toCustomerInfo(shippingAddress))
//                .collect(Collectors.toList());
        return null;
    }

    @Override
    public ShippingAddress create(CreateShippingAddressParam createShippingAddressParam) {
//
//        ShippingAddress shippingAddress = shippingAddressRepository.save(shippingAddressMapper.toModel(createShippingAddressParam));
        //  return  shippingAddressRepository.save(shippingAddressMapper.toModel(createShippingAddressParam));
        return null;
    }
}
