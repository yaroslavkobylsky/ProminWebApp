package com.promin_ism.controller;

import com.promin_ism.dao.DatabaseException;
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

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

@Controller
public class EditPartController {
    private static final Logger LOGGER = Logger.getLogger(EditPartController.class);

    @Autowired
    private PartService partService;

    @Autowired
    private ProductionMethodService productionMethodService;

    @Autowired
    private MaterialService materialService;

    @RequestMapping(value = "/parts/edit", method = RequestMethod.GET)
    public ModelAndView viewPart(Long id) {
        Part part = null;
        try {
            part = partService.read(id);
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return new ModelAndView("partsEdit", "part", part);
    }

    @RequestMapping(value = "/isPartNameUniqueInEdit", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Boolean> isPartNameUniqueInEdit(String name, Long id) {
        try {
            return Collections.singletonMap("result", partService.isNameUniqueInEdit(name, id));
        } catch (DatabaseException e) {
            e.printStackTrace();
            return Collections.singletonMap("result", false);
        }
    }

    @RequestMapping(value = "/parts/edit", method = RequestMethod.POST)
    public String savePart(Long id,
                           String partName,
                           String partDescName,
                           BigDecimal partMaterialNormWeight,
                           Boolean isPurchased,
                           Long material,
                           WebRequest request,
                           HttpSession httpSession) {
        try {
            Part part = partService.read(id);
            part.setName(partName.trim());
            part.setDescName(partDescName.trim());
            part.setMaterialNormWeight(partMaterialNormWeight);
            part.setIsPurchased(isPurchased);
            if (material != null) {
                part.setMaterial(materialService.read(material));
            }

            Map<String, String[]> requestParameters = request.getParameterMap();
            ArrayList<ProductionMethod> productionMethods = new ArrayList<ProductionMethod>();
            for (Map.Entry<String, String[]> entry : requestParameters.entrySet()) {
                if (entry.getKey().contains(NewPartController.METHOD)) {
                    Long productionMethodId = Long.parseLong(entry.getValue()[0]);
                    productionMethods.add(productionMethodService.read(productionMethodId));
                }
            }
            part.setProductionMethods(productionMethods);
            part.setUser((User) httpSession.getAttribute("user"));
            part.setLastDate(new Date());
            partService.update(part);
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return "redirect:viewAll";
    }
}
