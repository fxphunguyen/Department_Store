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
        this.debt = iCustomer.getORDER_DEBT();
        this.spend = iCustomer.getTOTAL_PRICE_SPENDING();
        this.numberProductOrdered = iCustomer.getQUANTITY_PRODUCT_ORDER();
        this.numberQuantityOrdered = iCustomer.getQUANTITY_ITEMS_ORDER();
        this.numberQuantityReturned = iCustomer.getQUANTITY_PRODUCT_PAY();
        this.employeeName = iCustomer.getEMPLOYEE_NAME();
        this.lastDateOrdered = iCustomer.getPRODUCT_ORDER_FINAL();

    }
}
