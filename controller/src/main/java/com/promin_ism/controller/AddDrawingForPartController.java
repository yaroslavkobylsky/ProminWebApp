package com.promin_ism.controller;

import com.promin_ism.dao.DrawingDao;
import com.promin_ism.dao.PartDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddDrawingForPartController {
    private static final Logger LOGGER = Logger.getLogger(AddDrawingForPartController.class);

    @Autowired
    private PartDao partDao;

    @Autowired
    private DrawingDao drawingDao;

    @RequestMapping(value = "parts/addDrawing/{partId}", method = RequestMethod.POST)
    public String addDrawingToPart(@PathVariable Long partId){
        LOGGER.debug("part id: " + partId);
        return "redirect:/parts/view?id=" + partId.toString();
    }

}
