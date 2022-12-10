package com.phpn.order.sale;

import com.phpn.customer.*;
import com.phpn.employee.*;
import com.phpn.employee.dto.*;
import com.phpn.exceptions.*;
import com.phpn.order.sale.dto.*;
import com.phpn.order.sale.item.*;
import com.phpn.product.*;
import com.phpn.product.item.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.fx.qh.sapo.entities.customer.*;
import vn.fx.qh.sapo.entities.employee.*;
import vn.fx.qh.sapo.entities.order.*;
import vn.fx.qh.sapo.entities.order.sale.*;
import vn.fx.qh.sapo.entities.product.*;
import vn.fx.qh.sapo.entities.product.tax.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;


@Service
public class SaleOrderServiceImpl implements SaleOrderService {


    @Autowired
    private SaleOrderRepository saleOrderRepository;

    @Autowired
    private SaleOrderItemRepository orderItemRepository;

    @Autowired
    SaleOrderMapper orderMapper;

    @Autowired
    SaleOrderItemMapper orderItemMapper;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private CustomerRepository customerRepository;


    @Autowired
    private ProductTaxRepository productTaxRepository;

    @Override
    @Transactional(readOnly = true)
    public List<SaleOrderResult> findAll() {
        return saleOrderRepository.findAll()
                .stream()
                .map(orderMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public SaleOrderResult create(SaleOrderParam orderParam) {
        Integer customerId = orderParam.getCustomerId();
        if (customerId == null && !customerRepository.existsById(customerId))
            throw new NotFoundException("Không tìm thấy khách hàng");


        SaleOrder order = orderMapper.toModel(orderParam);
        order.setGrandTotal(new BigDecimal(0));
        order.setTotal(new BigDecimal(0));

        order.setSubTotal(new BigDecimal(0));
        order.setLine1(order.getLine1());
        order.setLine2(order.getLine2());
        order.setCustomerId(customerId);
        order.setEmployeeId(1);
        order.setOrderStatus(OrderStatusCode.CHECKOUT);
        order.setPaymentStatus(OrderStatusCode.UNPAID);
        order = saleOrderRepository.save(order);
        order.setOrderCode("SON" + order.getId());
        BigDecimal total = BigDecimal.valueOf(0);
        BigDecimal subTotal = BigDecimal.valueOf(0);
        BigDecimal grandTotal = BigDecimal.valueOf(0);
        for (SaleOrderItemParam saleOrderItemParam : orderParam.getSaleOrderItems()) {

            Optional<Product> productOptional = productRepository.findById(saleOrderItemParam.getProductId());

            if (!productOptional.isPresent()) {
                throw new NotFoundException("Không tìm thấy Id sản phẩm " + saleOrderItemParam.getProductId());
            }
            //lấy toàn bộ item theo productId
            List<Item> items = itemRepository.findAllByProductIdAndAvailableGreaterThanOrderByCreatedAt(saleOrderItemParam.getProductId(), 0);
            int totalAvailable = items.stream().mapToInt(Item::getAvailable).sum();
            if (totalAvailable < saleOrderItemParam.getQuantity()) {
                throw new NotEnoughQuantityException("Không đủ số lượng cho đơn hàng, vui lòng kiểm tra lại !");
            }
            Product product = productOptional.get();
            Integer productId = product.getId();
            BigDecimal retailPrice = product.getRetailPrice();

            int quantityCustomerOrder = saleOrderItemParam.getQuantity();
            BigDecimal orderItemTotal = retailPrice.multiply(new BigDecimal(quantityCustomerOrder));

            SaleOrderItem saleOrderItem = new SaleOrderItem();
            if (product.getApplyTax()) {
                List<ProductTax> productTaxList = productTaxRepository.findAllByProductIdAndTaxType(productId, TaxType.TAX_SALE);
                float taxTotal = (float) productTaxList.stream()
                        .mapToDouble(productTax -> productTax.getTax().getTax()).sum();
                saleOrderItem.setTax(taxTotal);
                BigDecimal amountTax = (orderItemTotal.multiply(BigDecimal.valueOf(taxTotal / 100)));
                orderItemTotal = orderItemTotal.add(amountTax);
            }


            if (saleOrderItem.getDiscount() != null) {
                orderItemTotal = orderItemTotal.subtract(orderParam.getDiscount());
            }

            subTotal = subTotal.add(orderItemTotal);

            for (Item item : items) {
                if (quantityCustomerOrder == 0) {
                    break;
                }
                int available = item.getAvailable();
                int orderItemSold;
                if (quantityCustomerOrder >= available) {
                    quantityCustomerOrder = quantityCustomerOrder - available;
                    item.setAvailable(0);
                    orderItemSold = available;
                    int itemSold = item.getSold() + available;
                    item.setSold(itemSold);
                } else {
                    available = available - quantityCustomerOrder;
                    item.setAvailable(available);
                    orderItemSold = quantityCustomerOrder;
                    int itemSold = item.getSold() + quantityCustomerOrder;
                    item.setSold(itemSold);
                    quantityCustomerOrder = 0;
                }

                saleOrderItem.setQuantity(orderItemSold);
                saleOrderItem.setPrice(retailPrice);
                saleOrderItem.setProductId(productId);
                saleOrderItem.setItemId(item.getId());
                saleOrderItem.setOrderId(order.getId());
                saleOrderItem.setDiscount(saleOrderItemParam.getDiscount());
                orderItemRepository.save(saleOrderItem);
            }
        }
        order.setSubTotal(subTotal);
        //cong them phi giao hang
        total = subTotal.add(BigDecimal.valueOf(0));
        order.setTotal(total);
        if (order.getDiscount() != null) {
            grandTotal = total.subtract(order.getDiscount());
        } else {
            grandTotal = total;
        }
        //tru ma giam gia
        order.setGrandTotal(grandTotal);
        return orderMapper.toDTO(order);


    }

    @Override
    @Transactional
    public SaleOrderResult findById(int id) {
        Optional<SaleOrder> optional = saleOrderRepository.findById(id);
        if (!optional.isPresent())
            throw new NotFoundException("Đơn hàng không hợp lệ!");
        SaleOrderResult result = orderMapper.toDTO(optional.get());
        List<SaleOrderItemResult> orderItems = orderItemRepository.findAllByOrderId(result.getId())
                .stream()
                .map(orderItemMapper::toDTO)
                .collect(Collectors.toList());
        result.setOrderItems(orderItems);
        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public BigDecimal getSpendTotalByCustomerId(Integer customerId) {
        return saleOrderRepository.getSpendTotalByCustomerId(customerId);
    }

    @Override
    public Integer getQuantityProductOrder(Integer id) {
        return saleOrderRepository.getQuantityProductOrderById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SaleOrderResult> findAllSaleOrderByCustomerId(Integer customerId) {
<<<<<<< HEAD
        return  saleOrderRepository.findAllCustomerOrderHistory(customerId).stream().map(orderMapper::toCustomerHistory).collect(Collectors.toList());
=======
        return saleOrderRepository.findAllCustomerOrderHistory(customerId).stream().map(orderMapper::toDTO).collect(Collectors.toList());
>>>>>>> main
    }

    @Override
    @Transactional(readOnly = true)
    public Instant getLastDayOrderByCustomerId(Integer customerId) {
        return saleOrderRepository.getLastDayOrderByCustomerId(customerId);
    }


}
