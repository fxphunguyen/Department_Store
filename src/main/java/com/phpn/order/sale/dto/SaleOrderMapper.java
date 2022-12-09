package com.phpn.order.sale.dto;

import com.phpn.customer.ShippingAddressMapper;
import com.phpn.order.OrderStatusMapper;
import com.phpn.customer.CustomerMapper;
import com.phpn.employee.dto.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vn.fx.qh.sapo.entities.order.sale.*;

@Component
public class SaleOrderMapper {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private OrderStatusMapper orderStatusMapper;

    @Autowired
    private ShippingAddressMapper shippingAddressMapper;

    public SaleOrderResult toDTO(SaleOrder order) {
        return new SaleOrderResult()
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
                .setCustomerId(order.getCustomerId())
                .setCustomer(customerMapper.toDTO(order.getCustomer()))
                .setTotal(order.getTotal())
                .setSubTotal(order.getSubTotal())
                .setGrandTotal(order.getGrandTotal())
                .setCreatedAt(order.getCreatedAt())
                .setUpdatedAt(order.getUpdatedAt())
                .setShippingAddress(shippingAddressMapper.toDTO(order.getCustomer().getShippingAddress()));
    }

    public SaleOrder toModel(SaleOrderParam orderParam) {
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
                .setEmployeeId(orderParam.getEmployeeId());
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


