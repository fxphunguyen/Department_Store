package com.phpn.shipping_address;

import vn.fx.qh.sapo.entities.customer.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Integer> {

    @Query(value = "SELECT * FROM shipping_address where customer_id = :id" , nativeQuery = true)
    List<ShippingAddress> findAllShippingAddress(Integer id);


}
