package com.phpn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class PurchaseOrderController {

    @GetMapping("/purchase_order")
    public ModelAndView showListPurchase() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/purchase_order");
        return modelAndView;
    }
}
