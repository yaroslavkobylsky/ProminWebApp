package com.promin_ism.controller;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.Material;
import com.promin_ism.service.MaterialService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class ViewAllMaterialsController {
    private static final Logger LOGGER = Logger.getLogger(ViewAllMaterialsController.class);

    @Autowired
    private MaterialService materialService;

    @RequestMapping(value = "/materials/viewAll", method = RequestMethod.GET)
    public ModelAndView viewAllMaterials (){
        List<Material> materials = Collections.EMPTY_LIST;
        try {
            materials = materialService.findAll();
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return new ModelAndView("materialViewAll", "materials", materials);
    }
}
