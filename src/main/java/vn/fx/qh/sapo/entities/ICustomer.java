package vn.fx.qh.sapo.entities;

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
    BigDecimal getTOTAL_PRICE_SPENDING();
    BigDecimal getORDER_DEBT();
    int getQUANTITY_ITEMS_ORDER();
    String getEMPLOYEE_NAME();
    Date getPRODUCT_ORDER_FINAL();
    int getQUANTITY_PRODUCT_ORDER();
    int getQUANTITY_PRODUCT_PAY();
    Date getDAY_ORDER_LATTER();
}