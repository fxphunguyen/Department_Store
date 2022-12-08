package com.phpn.order;

import com.phpn.order.sale.dto.OrderParam;
import com.phpn.order.sale.dto.OrderResult;
import com.phpn.customer.CustomerMapper;
import com.phpn.employee.dto.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.fx.qh.sapo.entities.order.sale.*;

@Component
public class SaleOrderMapper {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private OrderStatusMapper orderStatusMapper;

    public OrderResult toDTO(SaleOrder order) {
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
                .setOrderStatusId(order.getOrderStatusCode().getValue())
                .setOrderStatus(orderStatusMapper.toDTO(order.getOrderStatus()))
                .setPaymentStatusId(order.getPaymentStatusCode().getValue())
                .setPaymentStatus(orderStatusMapper.toDTO(order.getPaymentStatus()))
                .setDiscount(order.getDiscount())
                .setDescription(order.getDescription())
                .setCreateAt(order.getCreateAt())
                .setCustomerId(order.getCustomerId())
                .setCustomer(customerMapper.toDTO(order.getCustomer()))
                .setTotal(order.getTotal())
                .setSubTotal(order.getSubTotal())
                .setGrandTotal(order.getGrandTotal());
    }

    public SaleOrder toModel(OrderParam orderParam) {
        return new SaleOrder()
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
                .setCreateAt(orderParam.getCreateAt());
                //.setOrderStatusId(orderParam.getOrderStatusId());

    }
}


