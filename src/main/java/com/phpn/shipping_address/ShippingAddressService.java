package com.phpn.customer;

import com.phpn.customer.CreateShippingAddressParam;
import com.phpn.customer.ShippingAddressShowCustomerInfo;
import vn.fx.qh.sapo.entities.ShippingAddress;

import java.util.List;

public interface ShippingAddressService {

    List<ShippingAddressShowCustomerInfo> findByCustomerId(Integer id);

    ShippingAddress create(CreateShippingAddressParam createShippingAddressParam);
}
