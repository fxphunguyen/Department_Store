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
    public SaleOrderResult toCustomerHistory(SaleOrder saleOrder) {
        return new SaleOrderResult()
                .setId(saleOrder.getId())
                .setFullName(saleOrder.getFullName())
                .setEmployee(employeeMapper.toDTO(saleOrder.getEmployee()))
                .setOrderCode(saleOrder.getOrderCode())
                .setOrderStatus(orderStatusMapper.toDTO(saleOrder.getOrderStatus()))
                .setPaymentStatusId(saleOrder.getPaymentStatusCode().getValue())
                .setPaymentStatus(orderStatusMapper.toDTO(saleOrder.getPaymentStatus()))
                .setDescription(saleOrder.getDescription())
                .setCreatedAt(saleOrder.getCreatedAt())
                .setCustomer(customerMapper.toDTO(saleOrder.getCustomer()))
                .setTotal(saleOrder.getTotal())
                .setSubTotal(saleOrder.getSubTotal())
                .setGrandTotal(saleOrder.getGrandTotal());
    }

}


