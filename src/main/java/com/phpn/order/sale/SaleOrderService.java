package com.phpn.order.sale;

import com.phpn.order.sale.dto.SaleOrderByCustomer;
import com.phpn.order.sale.dto.SaleOrderParam;
import com.phpn.order.sale.dto.SaleOrderResult;

import java.math.BigDecimal;
import java.util.List;

public interface SaleOrderService {

    List<SaleOrderResult> findAll();

    SaleOrderResult createOrderExport(SaleOrderParam orderParam);

    SaleOrderResult findById(int id);

    BigDecimal getSpendTotal(Integer customerId);

    Integer getQuantityProductOrder(Integer id);

    List<SaleOrderResult> findAllSaleOrderByCustomer(Integer id);
}
