package com.promin_ism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewMaterialController {

    /*@RequestMapping(value = "/materials/new", method = RequestMethod.GET)
    public String newMaterial(){
        return "materialNew";
    }*/

    @RequestMapping(value = "/materials/new", method = RequestMethod.GET)
    public ModelAndView newMaterial(){
        String message = "HELLO!!!";
        return new ModelAndView("materialNew", "message", message);
    }
}
