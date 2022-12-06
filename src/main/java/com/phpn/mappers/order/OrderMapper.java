package com.phpn.mappers.order;

import com.phpn.dto.order.OrderParam;
import com.phpn.dto.order.OrderResult;
import com.phpn.mappers.OrderStatusMapper;
import com.phpn.mappers.customer.CustomerMapper;
import com.phpn.mappers.employee.EmployeeMapper;
import com.phpn.repositories.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private OrderStatusMapper orderStatusMapper;

    public OrderResult toDTO(Order order) {
        return new OrderResult()
                .setId(order.getId())
                .setEmployeeId(order.getEmployeeId())
                .setEmployee(employeeMapper.toOrderDTO(order.getEmployee()))
                .setOrderCode(order.getOrderCode())
                .setOrderStatusId(order.getOrderStatusId())
                .setOrderStatus(orderStatusMapper.toDTO(order.getOrderStatus()))
                .setDiscount(order.getDiscount())
                .setDescription(order.getDescription())
                .setCreateAt(order.getCreateAt())
                .setCustomerId(order.getCustomerId())
                .setCustomer(customerMapper.toOrderDTO(order.getCustomer()))
                .setTotal(order.getTotal())
                .setSubTotal(order.getSubTotal())
                .setGrandTotal(order.getGrandTotal());
    }

    public Order toModel(OrderParam orderParam) {
        return new Order()
                .setId(orderParam.getId())
                .setDiscount(orderParam.getDiscount())
                .setDescription(orderParam.getDescription())
                .setCustomerId(orderParam.getCustomerId())
                .setOrderCode(orderParam.getOrderCode())
                .setEmployeeId(orderParam.getEmployeeId())
                .setCreateAt(orderParam.getCreateAt())
                .setOrderStatusId(orderParam.getOrderStatusId());

    }
}


