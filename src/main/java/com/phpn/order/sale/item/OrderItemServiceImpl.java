package com.phpn.order.sale;

import com.phpn.order.sale.dto.OrderItemResult;
import com.phpn.product.item.ItemMapper;
import com.phpn.order.SaleOrderMapper;
import com.phpn.order.SaleOrderItemMapper;
import com.phpn.product.ProductMapper;
import com.phpn.product.item.ItemRepository;
import com.phpn.order.SaleOrderItemRepository;
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
    public List<OrderItemResult> findAll() {
        return null;
    }

 @Override
 public List<OrderItemResult> findAllOrderItemByOrderId(Integer orderId) {
     return orderItemRepository.findAllByOrderId(orderId)
             .stream().map(orderItem -> orderItemMapper.toDTO(orderItem))
             .collect(Collectors.toList());
 }
}
