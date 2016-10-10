package com.promin_ism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewAllMaterialsController {

    @RequestMapping(value = "/materials/viewAll", method = RequestMethod.GET)
    public String viewAllMaterials (){
        return "materialViewAll";
    }
}
