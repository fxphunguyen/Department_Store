package com.phpn.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/home")
public class DashboardController {


    @RequestMapping()
    public String showDashboardPage(){
        return "/admin/home/dashboard";
    }
}
