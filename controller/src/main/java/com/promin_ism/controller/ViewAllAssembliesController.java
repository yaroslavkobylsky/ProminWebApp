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

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ViewAllAssembliesController {
    private static final Logger LOGGER = Logger.getLogger(ViewAllAssembliesController.class);

    @Autowired
    private AssemblyService assemblyService;

    @RequestMapping(value = "/assemblies/viewAll", method = RequestMethod.GET)
    public ModelAndView viewAllAssemblies() {
        List<Assembly> assemblies = Collections.emptyList();
        try {
            assemblies = assemblyService.findAll();
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return new ModelAndView("assemblyViewAll", "assemblies", assemblies);
    }

    @RequestMapping(value = "/createNewAssembly", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Long> createNewAssembly(String name) {
        Assembly assembly = new Assembly();
        assembly.setName(name.trim());
        try {
            Long id = assemblyService.create(assembly);
            return Collections.singletonMap("result", new Long(id));
        } catch (DatabaseException e) {
            LOGGER.error(e);
            return Collections.singletonMap("result", new Long(-1));
        }
    }

    @RequestMapping(value = "/isAssemblyNameUnique", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Boolean> isAssemblyNameUnique(String name) {
        Map<String, Boolean> result = new HashMap<String, Boolean>();
        try {
            result.put("result", assemblyService.isNameUnique(name));
            return result;
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return null;
    }
}
