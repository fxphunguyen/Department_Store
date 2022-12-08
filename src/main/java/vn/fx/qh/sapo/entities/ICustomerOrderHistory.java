package vn.fx.qh.sapo.entities;

import java.math.BigDecimal;
import java.util.Date;

public interface ICustomerOrderHistory {

    Integer getCustomer_id();

    String getCustomerName();

    Integer getOrder_id();

    String getOrder_code();

    String getStatus();



    BigDecimal getGrand_total();

    String getEmployee_name();

    BigDecimal getPrice_pay();

    BigDecimal getDebt();

    Date getCreate_at();


}
