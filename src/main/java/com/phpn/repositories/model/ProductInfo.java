package com.phpn.repositories.model;

import java.math.BigDecimal;

public interface ProductInfo {
     Integer getId();
     String getTitle();
     String getUnit();
     String getSku();
     String getBar_code();
     String getImage();
     String getDescription();
     Integer getQuantity();
     BigDecimal getRetail_price();
     Integer getInventory();
     Integer getAvailable();
     Integer getTrading();
     Boolean getApply_tax();
     Float getTax();
     Integer getTax_id();
}
