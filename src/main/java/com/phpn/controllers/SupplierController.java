package com.phpn.controllers;

import lombok.RequiredArgsConstructor;
import com.phpn.services.suppliers.SupplierService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/suppliers")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ModelAndView showSupplierListPage() {
        return new ModelAndView("/admin/suppliers/supplier_list");
    }

    @GetMapping("/{id}/histories")
    public ModelAndView showSupplierHistoryPage(@PathVariable Integer id) {
        ModelAndView modelAndView = new ModelAndView("/admin/suppliers/supplier_history");
        modelAndView.addObject("suppliers", supplierService.findById(id));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showSupplierCreatePage() {
        return new ModelAndView("/admin/suppliers/supplier_create");
    }

}