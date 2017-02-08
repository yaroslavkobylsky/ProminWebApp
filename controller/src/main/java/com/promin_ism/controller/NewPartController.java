package com.promin_ism.controller;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.Material;
import com.promin_ism.model.Part;
import com.promin_ism.model.ProductionMethod;
import com.promin_ism.model.User;
import com.promin_ism.service.MaterialService;
import com.promin_ism.service.PartService;
import com.promin_ism.service.ProductionMethodService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.*;

@Controller
public class NewPartController {
    private static final Logger LOGGER = Logger.getLogger(NewPartController.class);
    public static final String METHOD = "method";

    @Autowired
    private PartService partService;

    @Autowired
    private MaterialService materialService;

    @Autowired
    private ProductionMethodService productionMethodService;

    @RequestMapping(value = "/parts/new", method = RequestMethod.GET)
    public ModelAndView newPart(){
        String message = "HELLO!!!";
        return new ModelAndView("partsNew", "message", message);
    }

    @RequestMapping(value = "/parts/new", method = RequestMethod.POST)
    public String savePart(String partName,
                           String partDescName,
                           BigDecimal partMaterialNormWeight,
                           Boolean isPurchased,
                           Long material,
                           WebRequest request,
                           HttpSession httpSession){
        Part part = new Part();
        part.setName(partName);
        part.setDescName(partDescName);
        part.setMaterialNormWeight(partMaterialNormWeight);
        part.setIsPurchased(isPurchased);
        try {
            if (material != null){
                part.setMaterial(materialService.read(material));
            }

            Map<String, String[]> requestParameters = request.getParameterMap();
            ArrayList<ProductionMethod> productionMethods = new ArrayList<ProductionMethod>();
            for (Map.Entry<String, String[]> entry : requestParameters.entrySet()){
                if (entry.getKey().contains(METHOD)){
                    Long productionMethodId = Long.parseLong(entry.getValue()[0]);
                    LOGGER.debug("production method id: " + productionMethodId);
                    productionMethods.add(productionMethodService.read(productionMethodId));
                }
            }
            part.setProductionMethods(productionMethods);
            part.setUser((User) httpSession.getAttribute("user"));
            part.setLastDate(new Date());
            Long newId = partService.create(part);
            LOGGER.debug("new part id: " + newId);
            LOGGER.debug("part: " + part.toString());
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return "redirect:viewAll";
    }

    @RequestMapping(value = "/getMaterials", method = RequestMethod.GET)
    @ResponseBody
    public List<Material> getMaterials(){
        try {
            return materialService.findAll();
        } catch (DatabaseException e) {
            LOGGER.error(e);
            return Collections.emptyList();
        }
    }

    @RequestMapping(value = "/getProductionMethods", method = RequestMethod.GET)
    @ResponseBody
    public List<ProductionMethod> getProductionMethods(){
        try {
            return productionMethodService.findAll();
        } catch (DatabaseException e) {
            LOGGER.error(e);
            return Collections.emptyList();
        }
    }

    @RequestMapping(value = "/isPartNameUnique", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Boolean> isPartNameUnique(String name){
        LOGGER.debug("is part name unique: " + name);
        try {
            return Collections.singletonMap("result", new Boolean(partService.isNameUnique(name)));
        } catch (DatabaseException e) {
            e.printStackTrace();
            return Collections.singletonMap("result", new Boolean(false));
        }
    }
}
