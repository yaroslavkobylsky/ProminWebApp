package com.promin_ism.controller;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.Material;
import com.promin_ism.model.MaterialType;
import com.promin_ism.model.User;
import com.promin_ism.service.MaterialService;
import com.promin_ism.service.MaterialTypeService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Controller
public class NewMaterialController {
    private static final Logger LOGGER = Logger.getLogger(NewMaterialController.class);

    @Autowired
    private MaterialService materialService;

    @Autowired
    private MaterialTypeService materialTypeService;


    @RequestMapping(value = "/materials/new", method = RequestMethod.GET)
    public ModelAndView newMaterial(){
        return new ModelAndView("materialNew");
    }

    @RequestMapping(value = "/materials/new", method = RequestMethod.POST)
    public String saveMaterial(
            String materialName,
            String materialDimensions,
            String materialGOST,
            String materialSort,
            Integer materialType,
            HttpSession httpSession){
        LOGGER.debug("new material post method");
        Material material = new Material();
        LOGGER.debug("material name: " + materialName);
        material.setName(materialName.trim());
        material.setDimensions(materialDimensions.trim());
        material.setGost(materialGOST.trim());
        material.setSort(materialSort.trim());
        material.setDate(new Date());
        try {
            if (materialType != null && !materialType.equals(new Integer(-1))){
                material.setMaterilalType(materialTypeService.read(new Long(materialType)));
            }
            material.setUser((User) httpSession.getAttribute("user"));
            Long id = materialService.create(material);
            LOGGER.debug("new material created with id: " + id);
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }

        LOGGER.debug(material.toString());
        return "redirect:viewAll";
    }

    @RequestMapping(value = "/getMaterialTypes", method = RequestMethod.GET)
    @ResponseBody
    public List<MaterialType> getMaterialTypes(){
        try {
            return materialTypeService.findAll();
        } catch (DatabaseException e) {
            LOGGER.error(e);
            return Collections.emptyList();
        }
    }
}
