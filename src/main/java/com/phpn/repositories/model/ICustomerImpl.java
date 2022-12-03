package com.phpn.repositories.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ICustomerImpl
{
    private Long id;
    private String name;
    private String phone;
    private String customerGroup;
    private BigDecimal debt;
    private BigDecimal spend;
    private int numberProductOrdered;
    private String employeeName;
    private Date lastDateOrdered;
    private int numberQuantityOrdered;
    private int numberQuantityReturned;

    public void setFromICustomer(ICustomer iCustomer) {
        this.id = iCustomer.getID();
        this.name = iCustomer.getNAME();
        this.phone = iCustomer.getPHONE();
        this.customerGroup = iCustomer.getCUSTOMER_GROUP();
        this.debt = iCustomer.getCONGNO();
        this.spend = iCustomer.getCHITIEU();
        this.numberProductOrdered = iCustomer.getSL_MH_DAMUA();
        this.numberQuantityOrdered = iCustomer.getSL_SP_DAMUA();
        this.numberQuantityReturned = iCustomer.getSL_SP_HOANTRA();
        this.employeeName = iCustomer.getNV_PHUTRACH();
        this.lastDateOrdered = iCustomer.getNGM_CUOICUNG();

    }
}
