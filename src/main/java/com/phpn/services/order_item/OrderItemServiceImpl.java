package com.phpn.services.order_item;

import com.phpn.dto.item.ItemResult;
import com.phpn.dto.order.OrderResult;
import com.phpn.dto.orderItem.OrderItemResult;
import com.phpn.mappers.item.ItemMapper;
import com.phpn.mappers.order.OrderMapper;
import com.phpn.mappers.orderItem.OrderItemMapper;
import com.phpn.mappers.product.ProductMapper;
import com.phpn.repositories.OrderItemRepository;
import com.phpn.repositories.model.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<OrderItemResult> findAll() {
        return null;
    }
}
