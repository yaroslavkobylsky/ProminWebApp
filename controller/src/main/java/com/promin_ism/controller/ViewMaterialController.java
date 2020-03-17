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

@Controller
public class ViewMaterialController {
    private static final Logger LOGGER = Logger.getLogger(ViewMaterialController.class);

    private static final String MATERIAL_VIEW_NAME = "materialView";
    private static final String MATERIAL_MODEL_NAME = "material";

    @Autowired
    private MaterialService materialService;

    @RequestMapping(value = "materials/view", method = RequestMethod.GET)
    public ModelAndView viewMaterial(Long id) {
        Material material = null;
        try {
            material = materialService.read(id);
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return new ModelAndView(MATERIAL_VIEW_NAME, MATERIAL_MODEL_NAME, material);
    }
}
