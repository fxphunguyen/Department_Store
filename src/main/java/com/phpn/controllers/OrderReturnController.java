package com.phpn.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class OrderReturnController {

    @GetMapping("/admin/order_returns")
    public String showOrderReturnPage(){
        return "/admin/order_return/list_order_return";
    }
}
