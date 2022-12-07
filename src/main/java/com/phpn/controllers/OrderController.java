package com.phpn.controllers;

import com.phpn.services.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public ModelAndView showListOrderPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/order/list_orders");
        return modelAndView;
    }


    @GetMapping("/orders/create")
    public ModelAndView showCreateOrderPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/order/create");
        return modelAndView;
    }

    @GetMapping("/order_returns")
    public ModelAndView showOrderReturnPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/order/order_returns");
        return modelAndView;
    }

    @GetMapping("/orders/{id}")
    public ModelAndView showOrderDetail(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/order/order_id");
        modelAndView.addObject("orders", orderService.findById(id));
        return modelAndView;
    }

}
