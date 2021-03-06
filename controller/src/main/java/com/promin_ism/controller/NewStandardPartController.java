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
public class NewStandardPartController {
    private static final Logger LOGGER = Logger.getLogger(NewStandardPartController.class);

    @Autowired
    private StandardPartService standardPartService;

    @RequestMapping(value = "/standardParts/new", method = RequestMethod.GET)
    public ModelAndView newStandardPart() {
        return new ModelAndView("standardPartsNew");
    }

    @RequestMapping(value = "/standardParts/new", method = RequestMethod.POST)
    public String saveStandardPart(String standardPartName,
                                   String gost,
                                   BigDecimal weight,
                                   String additionalInfo,
                                   HttpSession httpSession) {
        StandardPart standardPart = new StandardPart();
        standardPart.setName(standardPartName.trim());
        standardPart.setGost(gost.trim());
        standardPart.setAdditionalInfo(additionalInfo.trim());
        standardPart.setWeight(weight);
        standardPart.setLastDate(new Date());
        standardPart.setUser((User) httpSession.getAttribute("user"));
        try {
            Long id = standardPartService.create(standardPart);
        } catch (DatabaseException e) {
            LOGGER.error(standardPart);
        }
        return "redirect:viewAll";
    }


    @RequestMapping(value = "/isStandardPartNameUnique", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Boolean> isStandardPartNameUnique(String name) {
        try {
            return Collections.singletonMap("result", standardPartService.isNameUnique(name));
        } catch (DatabaseException e) {
            e.printStackTrace();
            return Collections.singletonMap("result", false);
        }
    }
}
