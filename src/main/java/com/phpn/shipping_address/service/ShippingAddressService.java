package com.phpn.shipping_address.service;

import com.phpn.customer.dto.CreateShippingAddressParam;
import com.phpn.shipping_address.dto.ShippingAddressResult;

import java.util.List;

public interface ShippingAddressService {

    List<ShippingAddressResult> findByCustomerId(Integer id);

    ShippingAddressResult create(CreateShippingAddressParam createShippingAddressParam);

    void delete(Integer customerId);
}
