package com.phpn.repositories.model;

import java.math.BigDecimal;
import java.util.Date;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(String customerGroup) {
        this.customerGroup = customerGroup;
    }

    public BigDecimal getDebt() {
        return debt;
    }

    public void setDebt(BigDecimal debt) {
        this.debt = debt;
    }

    public BigDecimal getSpend() {
        return spend;
    }

    public void setSpend(BigDecimal spend) {
        this.spend = spend;
    }

    public int getNumberProductOrdered() {
        return numberProductOrdered;
    }

    public void setNumberProductOrdered(int numberProductOrdered) {
        this.numberProductOrdered = numberProductOrdered;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getLastDateOrdered() {
        return lastDateOrdered;
    }

    public void setLastDateOrdered(Date lastDateOrdered) {
        this.lastDateOrdered = lastDateOrdered;
    }

    public int getNumberQuantityOrdered() {
        return numberQuantityOrdered;
    }

    public void setNumberQuantityOrdered(int numberQuantityOrdered) {
        this.numberQuantityOrdered = numberQuantityOrdered;
    }

    public int getNumberQuantityReturned() {
        return numberQuantityReturned;
    }

    public void setNumberQuantityReturned(int numberQuantityReturned) {
        this.numberQuantityReturned = numberQuantityReturned;
    }
}
