package com.phpn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthenticationController {

    @GetMapping("/login")
    public ModelAndView showLoginPage() {
        return new ModelAndView("/admin/authentications/login");
    }

    @GetMapping("/register")
    public ModelAndView showRegisterPage() {
        return new ModelAndView("/admin/authentications/register");
    }

    @GetMapping("/404")
    public ModelAndView showExceptionPage() {
        return new ModelAndView("/admin/exceptions/exception");
    }

}