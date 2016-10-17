package com.promin_ism.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    private static final Logger LOGGER = Logger.getLogger(TestController.class);


    @RequestMapping("/test")
    public ModelAndView testPageHelloWorld() {
        String message = "hello motherfuckers";
        return new ModelAndView("test", "message", message);
    }

    @RequestMapping(value = "/testAJAX", method = RequestMethod.GET)
    @ResponseBody
    public  String testAjax(){
        LOGGER.debug("test ajax controller");
        return "json view resolver welcomes  you!";
    }
}
