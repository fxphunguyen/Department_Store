package com.phpn.order.sale.dto;

import com.phpn.order.OrderStatusMapper;
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

    public SaleOrderResult toDTO(SaleOrder saleOrder) {
        return new SaleOrderResult()
                .setId(saleOrder.getId())
                .setFullName(saleOrder.getFullName())
                .setMobile(saleOrder.getMobile())
                .setLine1(saleOrder.getLine1())
                .setLine2(saleOrder.getLine2())
                .setCity(saleOrder.getCity())
                .setProvince(saleOrder.getProvince())
                .setZipCode(saleOrder.getZipCode())
                .setEmployeeId(saleOrder.getEmployeeId())
                .setEmployee(employeeMapper.toDTO(saleOrder.getEmployee()))
                .setOrderCode(saleOrder.getOrderCode())
                .setOrderStatusId(saleOrder.getOrderStatusCode().getValue())
                .setOrderStatus(orderStatusMapper.toDTO(saleOrder.getOrderStatus()))
                .setPaymentStatusId(saleOrder.getPaymentStatusCode().getValue())
                .setPaymentStatus(orderStatusMapper.toDTO(saleOrder.getPaymentStatus()))
                .setDiscount(saleOrder.getDiscount())
                .setDescription(saleOrder.getDescription())
                .setCreatedAt(saleOrder.getCreatedAt())
                .setUpdatedAt(saleOrder.getUpdatedAt())
                .setCustomerId(saleOrder.getCustomerId())
                .setCustomer(customerMapper.toDTO(saleOrder.getCustomer()))
                .setTotal(saleOrder.getTotal())
                .setSubTotal(saleOrder.getSubTotal())
                .setGrandTotal(saleOrder.getGrandTotal());
    }

    public SaleOrder toModel(SaleOrderParam orderParam) {
        return new SaleOrder()
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
                .setOrderCode(orderParam.getOrderCode());
                //.setOrderStatusId(orderParam.getOrderStatusId());

    }

    public SaleOrderResult toCustomerOrder(SaleOrder order) {
        return new SaleOrderResult()
                .setId(order.getId())
                .setFullName(order.getFullName())
                .setEmployeeId(order.getEmployeeId())
                .setEmployee(employeeMapper.toDTO(order.getEmployee()))
                .setOrderCode(order.getOrderCode())
                .setOrderStatusId(order.getOrderStatusCode().getValue())
                .setOrderStatus(orderStatusMapper.toDTO(order.getOrderStatus()))
                .setPaymentStatusId(order.getPaymentStatusCode().getValue())
                .setPaymentStatus(orderStatusMapper.toDTO(order.getPaymentStatus()))
                .setDiscount(order.getDiscount())
                .setDescription(order.getDescription());
    }
}


