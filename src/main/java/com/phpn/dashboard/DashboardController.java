package com.phpn.dashboard;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/dashboard")
public class DashboardController {


    @RequestMapping()
    public String showDashboardPage(){
        return "/admin/home/dashboard";
    }
}
