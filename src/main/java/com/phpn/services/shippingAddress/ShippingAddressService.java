package com.phpn.services.shippingAddress;

import com.phpn.dto.shipping_address.ShippingAddressResult;
import com.phpn.repositories.model.ShippingAddress;

import java.util.List;

public interface ShippingAddressService {

    List<ShippingAddressResult> findByCustomerId(Integer id);

    ShippingAddressResult create();
}
