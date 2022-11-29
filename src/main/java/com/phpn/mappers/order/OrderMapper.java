package com.phpn.mappers.order;

import com.phpn.dto.order.OrderParam;
import com.phpn.dto.order.OrderResult;
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

    public OrderResult toDTO(Order order) {
        return new OrderResult()
                .setEmployee(employeeMapper.toDTO(order.getEmployee()))
                .setCustomer(customerMapper.toDTO(order.getCustomer()))
                .setStatus(order.getOrderStatus().getName())
                .setOrderCode(order.getOrderCode())
                .setCreateAt(order.getCreateAt())
                .setId(order.getId())
                .setGrandTotal(order.getGrandTotal())
                .setDescription(order.getDescription())
                .setDiscount(order.getDiscount())
                .setTotal(order.getTotal())
                .setGrandTotal(order.getGrandTotal());

    }

    public Order toModel(OrderParam orderParam) {
        return new Order()
                .setId(orderParam.getId())
                .setDiscount(orderParam.getDiscount())
                .setDescription(orderParam.getDescription())
                .setCreateAt(orderParam.getCreateAt())
                .setCustomerId(orderParam.getCustomerId())
                .setEmployeeId(orderParam.getEmployeeId())
                .setOrderStatusId(orderParam.getOrderStatusId());

    }
}


