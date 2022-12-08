package com.phpn.variant;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class VariantsController {
   @GetMapping("/variants")
    public ModelAndView showVariants(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/variants/variants");
        return modelAndView;
    }
}