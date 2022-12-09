package com.phpn.order.sale.item;

import com.phpn.order.sale.dto.SaleOrderItemResult;
import com.phpn.product.item.ItemMapper;
import com.phpn.order.sale.dto.SaleOrderMapper;
import com.phpn.order.sale.dto.SaleOrderItemMapper;
import com.phpn.product.dto.ProductMapper;
import com.phpn.product.item.ItemRepository;
import com.phpn.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {

  @Autowired
    ItemMapper itemMapper;

   @Autowired
   SaleOrderMapper orderMapper;

   @Autowired
   SaleOrderItemMapper orderItemMapper;

   @Autowired
    ProductMapper productMapper;

   @Autowired
   SaleOrderItemRepository orderItemRepository;

   @Autowired
   private ProductRepository productRepository;
   @Autowired
   private ItemRepository itemRepository;

    @Override
    public List<SaleOrderItemResult> findAll() {
        return null;
    }

 @Override
 public List<SaleOrderItemResult> findAllOrderItemByOrderId(Integer orderId) {
     return orderItemRepository.findAllByOrderId(orderId)
             .stream().map(orderItem -> orderItemMapper.toDTO(orderItem))
             .collect(Collectors.toList());
 }

 @Override
 public Integer getQuantityItemCustomerOrderById(Integer id) {
     return orderItemRepository.getQuantityItemCustomerOrderById(id);
 }
}
