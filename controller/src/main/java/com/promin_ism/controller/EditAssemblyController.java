package com.promin_ism.controller;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.Assembly;
import com.promin_ism.service.AssemblyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
public class EditAssemblyController {
    private static final Logger LOGGER = Logger.getLogger(EditAssemblyController.class);

    @Autowired
    AssemblyService assemblyService;

    @RequestMapping(value = "/assemblies/edit", method = RequestMethod.GET)
    public ModelAndView loadAssembly(Long id){
        Assembly assembly = null;
        try {
            assembly = assemblyService.read(id);
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return new ModelAndView("assemblyEdit", "assembly", assembly);
    }

    @RequestMapping(value = "/assemblies/edit/saveFields", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Long> saveFields(String name, String descName, String additional, Long id){
        LOGGER.debug("save fields method started");
        LOGGER.debug("name: " + name + " , desc name: " + descName + " , additional: " + additional + " , assembly id: " + id);
        Map<String, Long> returnMap = new HashMap();

        try {
            boolean result = assemblyService.isNameUniqueOnEdit(name, id);
            if(result){
                Assembly assembly = assemblyService.read(id);
                assembly.setName(name);
                assembly.setDescName(descName);
                assembly.setAdditionalInfo(additional);
                assembly.setLastDate(new Date());
                assemblyService.update(assembly);
                returnMap.put("result", new Long(1));
                return returnMap;
            }
            else {
                returnMap.put("result", new Long(-1));
                return returnMap;
            }
        } catch (DatabaseException e) {
            LOGGER.error(e);
            returnMap.put("result", new Long(0));
            return returnMap;
        }
    }
}
