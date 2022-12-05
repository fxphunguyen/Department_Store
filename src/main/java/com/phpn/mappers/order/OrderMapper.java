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
                .setId(order.getId())
                .setFullName(order.getFullName())
                .setMobile(order.getMobile())
                .setLine1(order.getLine1())
                .setLine2(order.getLine2())
                .setCity(order.getCity())
                .setProvince(order.getProvince())
                .setZipCode(order.getZipCode())
                .setEmployeeId(order.getEmployeeId())
                .setEmployee(employeeMapper.toDTO(order.getEmployee()))
                .setOrderCode(order.getOrderCode())
                .setOrderStatusId(order.getOrderStatusId())
                .setDiscount(order.getDiscount())
                .setDescription(order.getDescription())
                .setCreateAt(order.getCreateAt())
                .setCustomerId(order.getCustomerId())
                .setCustomer(customerMapper.toDTO(order.getCustomer()))
                .setTotal(order.getTotal())
                .setSubTotal(order.getSubTotal())
                .setGrandTotal(order.getGrandTotal());
    }

    public Order toModel(OrderParam orderParam) {
        return new Order()
                .setId(orderParam.getId())
                .setFullName(orderParam.getFullName())
                .setMobile(orderParam.getMobile())
                .setLine1(orderParam.getLine1())
                .setLine2(orderParam.getLine2())
                .setCity(orderParam.getCity())
                .setProvince(orderParam.getProvince())
                .setZipCode(orderParam.getZipCode())
                .setDiscount(orderParam.getDiscount())
                .setDescription(orderParam.getDescription())
                .setCustomerId(orderParam.getCustomerId())
                .setOrderCode(orderParam.getOrderCode())
                .setEmployeeId(orderParam.getEmployeeId())
                .setCreateAt(orderParam.getCreateAt())
                .setOrderStatusId(orderParam.getOrderStatusId());

    }
}


