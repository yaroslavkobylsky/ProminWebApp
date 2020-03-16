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

@Controller
public class CadSpecificationController {
    private static final String GET_CAD_SPECIFICATION =  "getCadSpecification";
    private static final String CAD_SPECIFICATION =  "cadSpecification";

    private static final Logger LOGGER = Logger.getLogger(CadSpecificationController.class);

    @Autowired
    private AssemblyService assemblyService;

    @RequestMapping(value = "/assemblies/getCadSpecification", method = RequestMethod.GET)
    public ModelAndView getCadSpecification(Long id) {
        try {
            Assembly assembly = assemblyService.read(id);
            return new ModelAndView(GET_CAD_SPECIFICATION, CAD_SPECIFICATION, assembly.getCadSpecification());
        } catch (DatabaseException e) {
            LOGGER.error(e);
            return new ModelAndView("errorPage", "exception", e);
        }
    }
}
