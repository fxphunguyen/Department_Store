package com.phpn.services.shippingAddress;

import com.phpn.dto.shipping_address.CreateShippingAddressParam;
import com.phpn.dto.shipping_address.ShippingAddressResult;
import com.phpn.dto.shipping_address.ShippingAddressShowCustomerInfo;
import com.phpn.repositories.model.ShippingAddress;

import java.util.List;

public interface ShippingAddressService {

    List<ShippingAddressShowCustomerInfo> findByCustomerId(Integer id);

    ShippingAddress create(CreateShippingAddressParam createShippingAddressParam);
}
