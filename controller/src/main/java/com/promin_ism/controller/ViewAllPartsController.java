package com.promin_ism.controller;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.Part;
import com.promin_ism.service.PartService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class ViewAllPartsController {
    private static final Logger LOGGER = Logger.getLogger(ViewAllPartsController.class);

    @Autowired
    private PartService partService;

    @RequestMapping(value = "/parts/viewAll", method = RequestMethod.GET)
    public ModelAndView newPart(){
        List<Part> parts = Collections.emptyList();
        try {
            parts = partService.findAll();
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return new ModelAndView("partsViewAll", "parts", parts);
    }
}
