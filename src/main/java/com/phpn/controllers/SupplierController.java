package com.phpn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class SupplierController {

    @GetMapping("/suppliers")
    public ModelAndView showSupplierPage() {
        return new ModelAndView("/admin/suppliers/suppliers");
    }

}