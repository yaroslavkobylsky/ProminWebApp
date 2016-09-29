package com.promin_ism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

    @RequestMapping("/test")
    public ModelAndView testPageHelloWorld() {
        String message = "hello motherfuckers";
        return new ModelAndView("test", "message", message);
    }
}
