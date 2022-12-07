package com.phpn.repositories;

import com.phpn.dto.shipping_address.ShippingAddressResult;
import com.phpn.repositories.model.ProductInfo;
import com.phpn.repositories.model.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Integer> {

    @Query(value = "SELECT * FROM shipping_address where customer_id = :id" , nativeQuery = true)
    List<ShippingAddress> findAllShippingAddress(Integer id);


}
