package com.promin_ism.controller;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.StandardPart;
import com.promin_ism.model.User;
import com.promin_ism.service.StandardPartService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

@Controller
public class EditStandardPartController {
    private static final Logger LOGGER = Logger.getLogger(EditStandardPartController.class);

    @Autowired
    private StandardPartService standardPartService;

    @RequestMapping(value = "/standardParts/edit", method = RequestMethod.GET)
    public ModelAndView editStandardPart(Long id){
        StandardPart standardPart = null;
        try {
            standardPart = standardPartService.read(id);
            LOGGER.debug("id: " + id);
            LOGGER.debug("standard part: " + standardPart.toString());
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return new ModelAndView("standardPartsEdit", "standardPart", standardPart);
    }

    @RequestMapping(value = "/standardParts/edit", method = RequestMethod.POST)
    public String saveStandardPart(Long id,
                                   String standardPartName,
                                   String gost,
                                   BigDecimal weight,
                                   String additionalInfo,
                                   HttpSession httpSession){
        try {
            StandardPart standardPart = standardPartService.read(id);
            standardPart.setName(standardPartName.trim());
            standardPart.setGost(gost.trim());
            standardPart.setAdditionalInfo(additionalInfo.trim());
            standardPart.setWeight(weight);
            standardPart.setLastDate(new Date());
            standardPart.setUser((User) httpSession.getAttribute("user"));
            standardPartService.update(standardPart);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        return "redirect:viewAll";
    }

    @RequestMapping(value = "/isStandardPartNameUniqueInEdit", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Boolean> isStandardPartNameUnique(String name, Long id){
        LOGGER.debug("is part name unique in edit: " + name + ", id: " + id);
        try {
            return Collections.singletonMap("result", new Boolean(standardPartService.isNameUniqueWhileEdit(name, id)));
        } catch (DatabaseException e) {
            e.printStackTrace();
            return Collections.singletonMap("result", new Boolean(false));
        }
    }
}
