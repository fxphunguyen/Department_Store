package com.phpn.repositories.model;

import java.math.BigDecimal;

public interface ProductInfo {
     Integer getID();
     String getTITLE();
     String getUNIT();
     String getSKU();
     String getPRODUCT_CODE();
     String getIMAGE();
     String getDESCRIPTION();
     Integer getQUANTITY();
     BigDecimal getRETAIL_PRICE();
     Integer getINVENTORY();
     Integer getAVAILABLE();
     Integer getTRADING();
}
