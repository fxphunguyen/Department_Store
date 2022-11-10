package com.phpn.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/order")
public class OrderController {

    @GetMapping("")
    public ModelAndView showOrderPage(){
        return new ModelAndView("/order/order_list");
    }


    @GetMapping("/create")
    public ModelAndView showOrderCreatePage(){
        return new ModelAndView("/order/create_order");
    }



}
