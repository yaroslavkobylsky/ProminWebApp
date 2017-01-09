package com.promin_ism.controller;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.Assembly;
import com.promin_ism.model.Part;
import com.promin_ism.service.AssemblyService;
import com.promin_ism.service.PartService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class EditAssemblyController {
    private static final Logger LOGGER = Logger.getLogger(EditAssemblyController.class);

    @Autowired
    private AssemblyService assemblyService;

    @Autowired
    private PartService partService;

    @RequestMapping(value = "/assemblies/edit", method = RequestMethod.GET)
    public ModelAndView loadAssembly(Long id){
        Assembly assembly = null;
        List<Part> parts = new ArrayList();
        try {
            assembly = assemblyService.read(id);
            parts = partService.findAll();
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        ModelAndView modelAndView = new ModelAndView("assemblyEdit", "assembly", assembly);
        modelAndView.addObject("parts", parts);
        return modelAndView;
    }

    @RequestMapping(value = "/assemblies/edit/saveFields", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Long> saveFields(String name, String descName, String additional, Long id){
        LOGGER.debug("save fields method started");
        LOGGER.debug("name: " + name + " , desc name: " + descName + " , additional: " + additional + " , assembly id: " + id);
        Map<String, Long> resultMap = new HashMap();

        try {
            boolean result = assemblyService.isNameUniqueOnEdit(name, id);
            if(result){
                Assembly assembly = assemblyService.read(id);
                assembly.setName(name);
                assembly.setDescName(descName);
                assembly.setAdditionalInfo(additional);
                assembly.setLastDate(new Date());
                assemblyService.update(assembly);
                resultMap.put("result", new Long(1));
                return resultMap;
            }
            else {
                resultMap.put("result", new Long(-1));
                return resultMap;
            }
        } catch (DatabaseException e) {
            LOGGER.error(e);
            resultMap.put("result", new Long(0));
            return resultMap;
        }
    }

    @RequestMapping(value = "/assemblies/edit/removePart", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Long> removePart(Long partId, Long assemblyId){
        LOGGER.debug("remove part from assembly method");
        LOGGER.debug("part id: " + partId + " , assembly id: " + assemblyId);
        Map<String, Long> resultMap = new HashMap();
        try {
            Assembly assembly = assemblyService.read(assemblyId);
            Part part = partService.read(partId);
            Long quantity = assembly.getParts().remove(part);
            if (quantity != null){
                assemblyService.update(assembly);
                resultMap.put("result", new Long(1));
                return resultMap;
            }
            else {
                resultMap.put("result", new Long(-1));
                return resultMap;
            }
        } catch (DatabaseException e) {
            LOGGER.error(e);
            resultMap.put("result", new Long(0));
            return resultMap;
        }
    }

    @RequestMapping(value = "/assemblies/edit/addPart", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Long> addPart(Long partId, Long assemblyId, Long quantity){
        LOGGER.debug("add part to assembly method");
        LOGGER.debug("part id: " + partId + ", assembly id: " + assemblyId + ", quantity: " + quantity);
        Map<String, Long> resultMap = new HashMap();
        try {
            Assembly assembly = assemblyService.read(assemblyId);
            Part part = partService.read(partId);
            if (assembly.addPart(part, quantity))
            {
                assemblyService.update(assembly);
                resultMap.put("result", new Long(1));
                return resultMap;
            }
            else {
                resultMap.put("result", new Long(-1));
                return resultMap;
            }
        } catch (DatabaseException e) {
            LOGGER.error(e);
            resultMap.put("result", new Long(0));
            return resultMap;
        }
    }
}
