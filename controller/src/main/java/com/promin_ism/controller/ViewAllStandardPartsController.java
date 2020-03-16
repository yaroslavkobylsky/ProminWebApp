package com.promin_ism.controller;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.StandardPart;
import com.promin_ism.service.StandardPartService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class ViewAllStandardPartsController {
    private static final Logger LOGGER = Logger.getLogger(ViewAllStandardPartsController.class);

    private static final String STANDARD_PARTS_VIEW_ALL_NAME = "standardPartsViewAll";
    private static final String STANDARD_PARTS_MODEL_NAME = "standardParts";

    @Autowired
    StandardPartService standardPartService;

    @RequestMapping(value = "/standardParts/viewAll", method = RequestMethod.GET)
    public ModelAndView newPart(){
        List<StandardPart> standardParts = Collections.emptyList();
        try {
            standardParts = standardPartService.findAll();
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return new ModelAndView(STANDARD_PARTS_VIEW_ALL_NAME, STANDARD_PARTS_MODEL_NAME, standardParts);
    }
}
