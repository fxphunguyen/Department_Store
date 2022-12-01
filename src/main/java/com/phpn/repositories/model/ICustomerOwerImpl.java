package com.phpn.repositories.model;

import java.math.BigDecimal;
import java.math.MathContext;

public class ICustomerOwerImpl {
    private String order_code;

    private String employee_name;

    private  String create_at;

    private BigDecimal transaction;


    private BigDecimal total_transaction;

    public ICustomerOwerImpl() {
    }


    public void setFromICustomerOwer(ICustomerOwer iCustomerOwer) {
        this.order_code = iCustomerOwer.getORDER_CODE();
        this.employee_name = iCustomerOwer.getEMPLOYEE_NAME();
        this.create_at = iCustomerOwer.getCREATEAT();
        this.transaction = iCustomerOwer.getTRANSACTION();
        this.total_transaction = iCustomerOwer.getTRANSACTION();
    }
    public String getOrder_code() {
        return order_code;
    }

    public void setOrder_code(String order_code) {
        this.order_code = order_code;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }



    public BigDecimal getTransaction() {
        return transaction;
    }

    public void setTransaction(BigDecimal transaction) {
        this.transaction = transaction;
    }
// b1.add(b2, MathContext.DECIMAL32);

    public BigDecimal getTotal_transaction() {
//        BigDecimal total = transaction.multiply(transaction);
        BigDecimal total = transaction.add(total_transaction, MathContext.DECIMAL32);
        return total;
    }

    public void setTotal_transaction(BigDecimal total_transaction) {
        this.total_transaction = total_transaction ;
    }
}

