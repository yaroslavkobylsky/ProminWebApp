package com.promin_ism.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AddDrawingForPartController {

    private static final String PART_VIEW_URL = "redirect:/parts/view?id=";

    @RequestMapping(value = "parts/addDrawing/{partId}", method = RequestMethod.POST)
    public String addDrawingToPart(@PathVariable Long partId) {
        return PART_VIEW_URL + partId.toString();
    }

}
