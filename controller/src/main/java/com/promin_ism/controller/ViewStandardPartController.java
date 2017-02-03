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

@Controller
public class ViewStandardPartController {
    private static final Logger LOGGER = Logger.getLogger(ViewStandardPartController.class);

    @Autowired
    private StandardPartService standardPartService;

    @RequestMapping(value = "/standardParts/view", method = RequestMethod.GET)
    public ModelAndView viewStandardPart(Long id){
        StandardPart standardPart = null;
        try {
            standardPart = standardPartService.read(id);
            LOGGER.debug("id: " + id);
            LOGGER.debug("standard part: " + standardPart.toString());
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return new ModelAndView("standardPartsView", "standardPart", standardPart);
    }
}
