package com.promin_ism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewAllPartsController {

    @RequestMapping(value = "/parts/viewAll", method = RequestMethod.GET)
    public ModelAndView newPart(){
        String message = "HELLO!!!";
        return new ModelAndView("partsViewAll", "message", message);
    }

}
