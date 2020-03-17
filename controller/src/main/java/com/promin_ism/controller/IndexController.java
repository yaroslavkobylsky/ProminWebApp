package com.promin_ism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {
    private static final String HOME = "home";

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String homePage() {
        return HOME;
    }
}
