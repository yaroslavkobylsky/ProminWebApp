package com.promin_ism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ViewAllStandardPartsController {

    @RequestMapping(value = "/standardParts/viewAll", method = RequestMethod.GET)
    public ModelAndView newPart(){
        String message = "view all standard parts";
        return new ModelAndView("standardPartsViewAll", "message", message);
    }
}
