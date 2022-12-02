package com.phpn.mappers.customer;


import com.phpn.dto.customer.CustomerOrderResult;
import com.phpn.repositories.model.ICustomerOwer;
import com.phpn.repositories.model.ICustomerOwerImpl;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ICustomerMapper {
    public ICustomerOwerImpl iCustomerImpls(ICustomerOwer iCustomerOwer){
        BigDecimal total = BigDecimal.valueOf(0);
        total = total.add(iCustomerOwer.getTRANSACTION());
        return new ICustomerOwerImpl()
                .setOrder_code(iCustomerOwer.getORDER_CODE())
                .setCreate_at(iCustomerOwer.getCREATEAT())
                .setEmployee_name(iCustomerOwer.getEMPLOYEE_NAME())
                .setTransaction(iCustomerOwer.getTRANSACTION())
                .setTotal_transaction(total);
    }
//
// return new CustomerOrderResult()
//                .setId(customer.getId())
//            .setCustomerCode(customer.getCustomerCode())
//            .setName(customer.getName())
//            .setPhone(customer.getPhone())
//            .setEmployeeId(customer.getEmployeeId())
//            .setLocationRegionResult(locationRegionMapper.toDTO(customer.getLocationRegion()));


}
