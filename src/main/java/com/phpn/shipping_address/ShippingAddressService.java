package com.phpn.shipping_address;

import com.phpn.customer.dto.CreateShippingAddressParam;
import vn.fx.qh.sapo.entities.customer.*;

import java.util.List;

public interface ShippingAddressService {

    List<ShippingAddressShowCustomerInfo> findByCustomerId(Integer id);

    ShippingAddress create(CreateShippingAddressParam createShippingAddressParam);
}
