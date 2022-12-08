package com.phpn.order.sale;
import vn.fx.qh.sapo.entities.order.sale.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface SaleOrderRepository extends JpaRepository<SaleOrder, Integer> {
    List<SaleOrder> findAllSaleOrderByCustomerId(Integer customerId);



    @Query(value = "call `ph-pn`.sp_getSpendTotalByCustomerId(:id);" , nativeQuery = true)
    BigDecimal getSpendTotalByCustomerId(Integer id);


}
