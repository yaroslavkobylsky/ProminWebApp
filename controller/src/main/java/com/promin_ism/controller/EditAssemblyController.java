package com.promin_ism.controller;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.Assembly;
import com.promin_ism.model.Material;
import com.promin_ism.model.Part;
import com.promin_ism.model.StandardPart;
import com.promin_ism.service.AssemblyService;
import com.promin_ism.service.MaterialService;
import com.promin_ism.service.PartService;
import com.promin_ism.service.StandardPartService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.*;

@Controller
public class EditAssemblyController {
    private static final Logger LOGGER = Logger.getLogger(EditAssemblyController.class);

    @Autowired
    private AssemblyService assemblyService;

    @Autowired
    private PartService partService;

    @Autowired
    private StandardPartService standardPartService;

    @Autowired
    private MaterialService materialService;

    @RequestMapping(value = "/assemblies/edit", method = RequestMethod.GET)
    public ModelAndView loadAssembly(Long id) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.addObject("assemblyEdit", assemblyService.read(id))
                    .addObject("parts", partService.findAll())
                    .addObject("standardParts", standardPartService.findAll())
                    .addObject("materials", materialService.findAll())
                    .addObject("assemblies", assemblyService.findAll());
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return modelAndView;
    }

    @RequestMapping(value = "/assemblies/edit/saveFields", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Long> saveFields(String name, String descName, String additional, Long id) {
        Long operationResult;
        try {
            if (assemblyService.isNameUniqueOnEdit(name, id)) {
                Assembly assembly = assemblyService.read(id);
                assembly.setName(name);
                assembly.setDescName(descName);
                assembly.setAdditionalInfo(additional);
                assembly.setLastDate(new Date());
                assemblyService.update(assembly);
                operationResult = 1L;
            } else {
                operationResult = -1L;
            }
        } catch (DatabaseException e) {
            LOGGER.error(e);
            operationResult = 0L;
        }

        HashMap<String, Long> result = new HashMap<String, Long>();
        result.put("result", operationResult);
        return result;
    }

    @RequestMapping(value = "/assemblies/edit/removePart", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Long> removePart(Long partId, Long assemblyId) {
        LOGGER.debug("remove part from assembly method");
        LOGGER.debug("part id: " + partId + " , assembly id: " + assemblyId);
        Map<String, Long> resultMap = new HashMap();
        try {
            Assembly assembly = assemblyService.read(assemblyId);
            Part part = partService.read(partId);
            Long quantity = assembly.getParts().remove(part);
            if (quantity != null) {
                assemblyService.update(assembly);
                resultMap.put("result", new Long(1));
                return resultMap;
            } else {
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
    public Map<String, Long> addPart(Long partId, Long assemblyId, Long quantity) {
        LOGGER.debug("add part to assembly method");
        LOGGER.debug("part id: " + partId + ", assembly id: " + assemblyId + ", quantity: " + quantity);
        Map<String, Long> resultMap = new HashMap();
        try {
            Assembly assembly = assemblyService.read(assemblyId);
            Part part = partService.read(partId);
            if (assembly.addPart(part, quantity)) {
                assemblyService.update(assembly);
                resultMap.put("result", new Long(1));
                return resultMap;
            } else {
                resultMap.put("result", new Long(-1));
                return resultMap;
            }
        } catch (DatabaseException e) {
            LOGGER.error(e);
            resultMap.put("result", new Long(0));
            return resultMap;
        }
    }

    @RequestMapping(value = "/assemblies/edit/addStandardPart", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Long> addStandardPart(Long standardPartId, Long assemblyId, Long quantity) {
        LOGGER.debug("add stabdard part to assembly method");
        LOGGER.debug("standard part id: " + standardPartId + ", assembly id: " + assemblyId + ", quantity: " + quantity);
        Map<String, Long> resultMap = new HashMap();
        try {
            Assembly assembly = assemblyService.read(assemblyId);
            StandardPart standardPart = standardPartService.read(standardPartId);
            if (assembly.addStandartPart(standardPart, quantity)) {
                assemblyService.update(assembly);
                resultMap.put("result", new Long(1));
                return resultMap;
            } else {
                resultMap.put("result", new Long(-1));
                return resultMap;
            }
        } catch (DatabaseException e) {
            LOGGER.error(e);
            resultMap.put("result", new Long(0));
            return resultMap;
        }
    }

    @RequestMapping(value = "/assemblies/edit/removeStandardPart", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Long> removeStandardPart(Long standardPartId, Long assemblyId) {
        LOGGER.debug("remove standard part from assembly method");
        LOGGER.debug("standard part id: " + standardPartId + " , assembly id: " + assemblyId);
        Map<String, Long> resultMap = new HashMap();
        try {
            Assembly assembly = assemblyService.read(assemblyId);
            StandardPart standardPart = standardPartService.read(standardPartId);
            Long quantity = assembly.getStandardParts().remove(standardPart);
            if (quantity != null) {
                assemblyService.update(assembly);
                resultMap.put("result", new Long(1));
                return resultMap;
            } else {
                resultMap.put("result", new Long(-1));
                return resultMap;
            }
        } catch (DatabaseException e) {
            LOGGER.error(e);
            resultMap.put("result", new Long(0));
            return resultMap;
        }
    }

    @RequestMapping(value = "/assemblies/edit/addMaterial", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Long> addMaterial(Long materialId, Long assemblyId, BigDecimal quantity) {
        LOGGER.debug("add material to assembly method");
        LOGGER.debug("material id: " + materialId + ", assembly id: " + assemblyId + ", quantity: " + quantity);
        Map<String, Long> resultMap = new HashMap();
        try {
            Assembly assembly = assemblyService.read(assemblyId);
            Material material = materialService.read(materialId);
            if (assembly.addMaterials(material, quantity)) {
                assemblyService.update(assembly);
                resultMap.put("result", new Long(1));
                LOGGER.debug("material was added to assembly");
                return resultMap;
            } else {
                resultMap.put("result", new Long(-1));
                LOGGER.debug("material was not added to assembly");
                return resultMap;
            }
        } catch (DatabaseException e) {
            LOGGER.error(e);
            resultMap.put("result", new Long(0));
            return resultMap;
        }
    }

    @RequestMapping(value = "/assemblies/edit/removeMaterial", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Long> removeMaterial(Long materialId, Long assemblyId) {
        LOGGER.debug("remove material from assembly method");
        LOGGER.debug("material id: " + materialId + " , assembly id: " + assemblyId);
        Map<String, Long> resultMap = new HashMap();
        try {
            Assembly assembly = assemblyService.read(assemblyId);
            Material material = materialService.read(materialId);
            BigDecimal quantity = assembly.getMaterials().remove(material);
            if (quantity != null) {
                assemblyService.update(assembly);
                resultMap.put("result", new Long(1));
                return resultMap;
            } else {
                resultMap.put("result", new Long(-1));
                return resultMap;
            }
        } catch (DatabaseException e) {
            LOGGER.error(e);
            resultMap.put("result", new Long(0));
            return resultMap;
        }
    }

    @RequestMapping(value = "/assemblies/edit/addAssembly", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Long> addAssembly(Long addAssemblyId, Long assemblyId, Long quantity) {
        LOGGER.debug("add assembly to assembly method");
        LOGGER.debug("adding assembly id: " + addAssemblyId + ", assembly id: " + assemblyId + ", quantity: " + quantity);
        Map<String, Long> resultMap = new HashMap();
        try {
            Assembly assembly = assemblyService.read(assemblyId);
            Assembly addingAssembly = assemblyService.read(addAssemblyId);
            if (assembly.addAssembly(addingAssembly, quantity)) {
                assemblyService.update(assembly);
                resultMap.put("result", new Long(1));
                return resultMap;
            } else {
                resultMap.put("result", new Long(-1));
                return resultMap;
            }
        } catch (DatabaseException e) {
            LOGGER.error(e);
            resultMap.put("result", new Long(0));
            return resultMap;
        }
    }

    @RequestMapping(value = "/assemblies/edit/removeAssembly", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Long> removeAssembly(Long removeAssemblyId, Long assemblyId) {
        LOGGER.debug("remove assembly from assembly method");
        LOGGER.debug("remove assembly id: " + removeAssemblyId + " , assembly id: " + assemblyId);
        Map<String, Long> resultMap = new HashMap();
        try {
            LOGGER.debug("reading assemblies");
            Assembly assembly = assemblyService.read(assemblyId);
            LOGGER.debug("main assembly: " + assembly.toString());
            Assembly removingAssembly = assemblyService.read(removeAssemblyId);
            LOGGER.debug("removed assembly: " + removingAssembly.toString());
            Long quantity = assembly.getAssemblies().remove(removingAssembly);
            LOGGER.debug("quantity: " + quantity);
            if (quantity != null) {
                assemblyService.update(assembly);
                resultMap.put("result", new Long(1));
                return resultMap;
            } else {
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
