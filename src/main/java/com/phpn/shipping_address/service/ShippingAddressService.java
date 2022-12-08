package com.phpn.shipping_address.service;

import com.phpn.customer.dto.CreateShippingAddressParam;
import com.phpn.shipping_address.dto.ShippingAddressShowCustomerInfo;
import vn.fx.qh.sapo.entities.customer.*;

import java.util.List;

public interface ShippingAddressService {

    List<ShippingAddressShowCustomerInfo> findByCustomerId(Integer id);

    ShippingAddress create(CreateShippingAddressParam createShippingAddressParam);
}
