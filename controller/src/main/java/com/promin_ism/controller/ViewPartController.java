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

@Controller
public class ViewPartController {
    private static final Logger LOGGER = Logger.getLogger(ViewPartController.class);

    @Autowired
    private PartService partService;

    @RequestMapping(value = "/parts/view", method = RequestMethod.GET)
    public ModelAndView viewPart(Long id){
        Part part = null;
        try {
            part = partService.read(id);
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return new ModelAndView("partsView", "part", part);
    }
}
