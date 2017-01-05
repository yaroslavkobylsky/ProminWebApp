package com.promin_ism.controller;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.Assembly;
import com.promin_ism.service.AssemblyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

@Controller
public class ViewAllAssembliesController {
    private static final Logger LOGGER = Logger.getLogger(ViewAllAssembliesController.class);

    @Autowired
    private AssemblyService assemblyService;

    @RequestMapping(value = "/assemblies/viewAll", method = RequestMethod.GET)
    public ModelAndView viewAllAssemblies(){
        List<Assembly> assemblies = Collections.emptyList();
        try {
            assemblies = assemblyService.findAll();
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return new ModelAndView("assemblyViewAll", "assemblies", assemblies);
    }
}
