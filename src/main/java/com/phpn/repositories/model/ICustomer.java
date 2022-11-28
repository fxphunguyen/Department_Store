package com.phpn.repositories.model;

import java.math.BigDecimal;
import java.util.Date;

public interface ICustomer {
    Long getID();
    String getNAME();
    String getPHONE();
    String getCUSTOMER_GROUP();
    BigDecimal getCHITIEU();
    BigDecimal getCONGNO();
    int getSL_MH_DAMUA();
    String getNV_PHUTRACH();
    Date getNGM_CUOICUNG();
    int getSL_SP_DAMUA();
    int getSL_SP_HOANTRA();
}
