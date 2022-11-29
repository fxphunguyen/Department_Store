package com.phpn.repositories.model;

import java.math.BigDecimal;
import java.util.Date;

public interface ICustomer {
    Long getID();
    String getCUSTOMER_CODE();
    String getNAME();
    String getADDRESS();
    String getPHONE();
    String getGENDER();
    String getBIRTHDAY();
    String getEmail();
    String getSTATUS();
    String getCUSTOMER_GROUP();
    Date getCREATE_AT();
    Date getUPDATE_AT();
    BigDecimal getCHITIEU();
    BigDecimal getCONGNO();
    int getSL_MH_DAMUA();
    String getNV_PHUTRACH();
    Date getNGM_CUOICUNG();
    int getSL_SP_DAMUA();
    int getSL_SP_HOANTRA();
}
