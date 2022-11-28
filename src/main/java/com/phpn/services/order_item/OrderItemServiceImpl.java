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
    @Transactional
    public OrderItemResult createOrderItem(OrderItemParam orderItemParam) {
        Integer productId = orderItemParam.getProductId();
        Integer itemId = orderItemParam.getItemId();
        BigDecimal totalProduct;
        int quantity = orderItemParam.getQuantity();

        Optional<Product> productOptional = productRepository.findById(productId);

        Optional<Item> itemOptional = itemRepository.findById(itemId);

        BigDecimal retailProduct = productOptional.get().getRetailPrice();

        if (productId == null){
            throw new NotEnoughQuantityException("Không tìm thấy Id sản phẩm");
        }

        OrderItem orderItem = orderItemMapper.toModel(orderItemParam);

        orderItem.setQuantity(orderItem.getQuantity() + 1);

        totalProduct = retailProduct.multiply(new BigDecimal(quantity));

        orderItem.setQuantity(quantity);
        orderItem.setItemId(itemId);
        orderItem.setProductId(productId);
        orderItem.setOrderId(orderItem.getId());
        orderItemRepository.save(orderItem);

        return orderItemMapper.toDTO(orderItem);
    }


}
