package com.phpn.repositories.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;



@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
public class ICustomerOwerImpl {
    private String order_code;

    private String employee_name;

    private  String create_at;

    private BigDecimal transaction;


    private  BigDecimal total_transaction;

    private  String description;


    public void setFromICustomerOwer(ICustomerOwer iCustomerOwer) {
        this.order_code = iCustomerOwer.getORDER_CODE();
        this.employee_name = iCustomerOwer.getEMPLOYEE_NAME();
        this.create_at = iCustomerOwer.getCREATEAT();
        this.transaction = iCustomerOwer.getTRANSACTION();
        this.total_transaction = iCustomerOwer.getTOTALTRANSACTION();
        this.description = iCustomerOwer.getDescription();
    }


}

