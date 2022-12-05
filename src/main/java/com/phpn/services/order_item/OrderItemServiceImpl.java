package com.phpn.services.order_item;

import com.phpn.dto.item.ItemResult;
import com.phpn.dto.order.OrderResult;
import com.phpn.dto.orderItem.OrderItemParam;
import com.phpn.dto.orderItem.OrderItemResult;
import com.phpn.exceptions.NotEnoughQuantityException;
import com.phpn.mappers.item.ItemMapper;
import com.phpn.mappers.order.OrderMapper;
import com.phpn.mappers.orderItem.OrderItemMapper;
import com.phpn.mappers.product.ProductMapper;
import com.phpn.repositories.ItemRepository;
import com.phpn.repositories.OrderItemRepository;
import com.phpn.repositories.ProductRepository;
import com.phpn.repositories.model.Item;
import com.phpn.repositories.model.OrderItem;
import com.phpn.repositories.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderItemServiceImpl implements OrderItemService {

  @Autowired
    ItemMapper itemMapper;

   @Autowired
    OrderMapper orderMapper;

   @Autowired
    OrderItemMapper orderItemMapper;

   @Autowired
    ProductMapper productMapper;

   @Autowired
    OrderItemRepository orderItemRepository;

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
