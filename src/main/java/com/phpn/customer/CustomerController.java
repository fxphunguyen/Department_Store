package com.phpn.customer;


import com.phpn.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/admin/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("")
    public String showListCustomerPage() {
        return "/admin/customer/list_customer";
    }

    @GetMapping("/customer_group")
    public String showCustomerGroupPage() {
        return "/admin/customer/customer_group";
    }

    @GetMapping("/create")
    public String showCustomerCreatePage() {
        return "/admin/customer/create_customer";
    }



    @GetMapping("/history")
    public String showCustomerHistoryPage() {
        return "/admin/customer/history_customer";
    }

    @GetMapping("/customerInfo/{id}")
    public ModelAndView showCustomerInfoPage(@PathVariable Integer id) {
        System.out.println(id);
        System.out.println("___________________________" + id);
        ModelAndView modelAndView = new ModelAndView();
//        ICustomer iCustomer = customerService.CustomerInfoById(id);
//        modelAndView.addObject("customer", iCustomer);
//        modelAndView.setViewName("/admin/customer/history_customer");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showCustomerEditPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        Optional<CustomerResult> customerOptional = Optional.ofNullable(customerService.findById(id));
        System.out.println(customerOptional.get());
        modelAndView.addObject("customer", customerOptional);
        modelAndView.setViewName("/admin/customer/edit_customer");
        return modelAndView;
    }

}