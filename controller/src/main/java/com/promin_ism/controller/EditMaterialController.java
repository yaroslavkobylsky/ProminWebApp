package com.promin_ism.controller;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.Material;
import com.promin_ism.model.User;
import com.promin_ism.service.MaterialService;
import com.promin_ism.service.MaterialTypeService;
import com.promin_ism.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
public class EditMaterialController {
    private static final Logger LOGGER = Logger.getLogger(EditMaterialController.class);

    @Autowired
    private MaterialService materialService;

    @Autowired
    MaterialTypeService materialTypeService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "materials/edit", method = RequestMethod.GET)
    public ModelAndView getMaterial(Long id) {
        Material material = null;
        try {
            material = materialService.read(id);
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return new ModelAndView("materialEdit", "material", material);
    }

    @RequestMapping(value = "materials/edit", method = RequestMethod.POST)
    public String saveMaterial(Long id,
                               String materialName,
                               String materialDimensions,
                               String materialGOST,
                               String materialSort,
                               Integer materialType,
                               HttpSession httpSession) {
        try {
            Material material = materialService.read(id);
            material.setName(materialName.trim());
            material.setDimensions(materialDimensions.trim());
            material.setGost(materialGOST.trim());
            material.setSort(materialSort.trim());
            material.setDate(new Date());
            if (materialType != null && !materialType.equals(-1)) {
                material.setMaterilalType(materialTypeService.read(new Long(materialType)));
            }
            material.setUser((User) httpSession.getAttribute("user"));
            materialService.update(material);
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return "redirect:viewAll";
    }
}
