package com.promin_ism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewStandardPartController {

    @RequestMapping(value = "/standardParts/new", method = RequestMethod.GET)
    public ModelAndView newPart(){
        String message = "new standard part";
        return new ModelAndView("standardPartsNew", "message", message);
    }
}
