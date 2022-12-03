package com.phpn.repositories.model;

import java.math.BigDecimal;
import java.util.Date;

public interface ICustomerOrderHistory {

    Integer getCustomer_id();

    Integer getOrder_id();

    String getOrder_code();

    String getStatus();

    Date getCreate_at();

    BigDecimal getGrand_total();

    String getEmployee_name();


}
