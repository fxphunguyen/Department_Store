package com.phpn.repositories.model;


import java.math.BigDecimal;

public interface ICustomerOwer {

    String getORDER_CODE();

    String getEMPLOYEE_NAME();

    String getCREATEAT();

    BigDecimal getTRANSACTION();

    BigDecimal getTOTALTRANSACTION();
}
