package com.phpn.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
    @RequestMapping("/customer")
public class CustomerController {



    @GetMapping("")
    public  String showListCustomerPage(){
        return  "/admin/customer/list_customer";
    }


    @GetMapping("/customer_group")
    public String showCustomerGroupPage(){
        return  "/admin/customer/customer_group";
    }

    @GetMapping("/create_customer")
    public String showCustomerCreatePage(){
        return  "/admin/customer/create_customer";
    }

}
