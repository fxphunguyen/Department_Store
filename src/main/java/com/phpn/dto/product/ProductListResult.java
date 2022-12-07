package com.phpn.dto.product;

public interface ProductListResult {
   Integer getId();
   String getTitle();
   String getImage();
   String getCategoryName();
   String getBrandName();
   String getStatus();
   String getCreateAt();
   String getUpdateAt();
   Integer getAvailable();
   Integer getTrading();
}
