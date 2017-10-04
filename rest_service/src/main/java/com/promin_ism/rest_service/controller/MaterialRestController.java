package com.promin_ism.rest_service.controller;

import com.promin_ism.model.Material;
import com.promin_ism.model.User;
import com.promin_ism.rest_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.promin_ism.rest_service.repository.MaterialRepository;

@RestController
/*@RequestMapping("/materials")*/
public class MaterialRestController {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private UserRepository userRepository;


    @RequestMapping(value = "/materials/{materialId}/user", method = RequestMethod.GET)
    public User getMaterialUser(@RequestParam Long materialId){
        return materialRepository.getOne(materialId).getUser();
    }

    @RequestMapping(value = "/materials/{materialId}", method = RequestMethod.GET)
    public Material getMaterial(@RequestParam Long materialId){
        return materialRepository.getOne(materialId);
    }
}
