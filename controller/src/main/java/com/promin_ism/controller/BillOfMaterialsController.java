package com.promin_ism.controller;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.Assembly;
import com.promin_ism.model.AssemblyUtility.BillOfMaterials;
import com.promin_ism.service.AssemblyService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BillOfMaterialsController {
    private static final String GET_BILL_OF_MATERIALS = "getBillOfMaterials";
    private static final String BILL_OF_MATERIALS = "billOfMaterials";

    private static final Logger LOGGER = Logger.getLogger(BillOfMaterialsController.class);

    @Autowired
    AssemblyService assemblyService;

    @RequestMapping(value = "/assemblies/getBillOfMaterials", method = RequestMethod.GET)
    public ModelAndView getBillOfMaterials(Long id) {
        ModelAndView modelAndView = new ModelAndView(GET_BILL_OF_MATERIALS);
        try {
            BillOfMaterials billOfMaterials = new BillOfMaterials();
            Assembly assembly = assemblyService.read(id);
            billOfMaterials.setAssembly(assembly);
            billOfMaterials.setBill(assembly.getBillOfMaterials());
            modelAndView.addObject(BILL_OF_MATERIALS, billOfMaterials);
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return modelAndView;
    }
}
