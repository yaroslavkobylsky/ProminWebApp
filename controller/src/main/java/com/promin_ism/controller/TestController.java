package com.promin_ism.controller;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.dao.UserDao;
import com.promin_ism.model.User;
import com.promin_ism.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    private static final Logger LOGGER = Logger.getLogger(TestController.class);

    @Autowired
    private UserService userService;


    @RequestMapping("/test")
    public ModelAndView testPageHelloWorld() {
        String message = "hello";
        return new ModelAndView("test", "message", message);
    }

    @RequestMapping(value = "/testAJAX", method = RequestMethod.GET)
    @ResponseBody
    public  String testAjax(){
        LOGGER.debug("test ajax controller");
        if (userService != null){
            LOGGER.debug("user service is not null");
        }
        else {
            LOGGER.debug( "user service is null");
        }

        try {
            User user = userService.read(new Long(0));
            return user.getName();
        } catch (DatabaseException e) {
            e.printStackTrace();
            return e.toString();
        }

    }
}
