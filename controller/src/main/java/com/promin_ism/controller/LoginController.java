package com.promin_ism.controller;

import com.promin_ism.dao.DatabaseException;
import com.promin_ism.model.User;
import com.promin_ism.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private static final Logger LOGGER = Logger.getLogger(LoginController.class);
    private static final String WRONG_MESSAGE = "wrong login or password!";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(){
        String message = "";
        return new ModelAndView("login","message", message);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView doLogin(String userName, String userPassword, HttpSession httpSession){
        try {
            User user = userService.getByLoginPass(userName, userPassword);
            if (user == null){
                return new ModelAndView("login","message", WRONG_MESSAGE);
            }
            else{
                httpSession.setAttribute("user", user);
                return new ModelAndView("home");
            }
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout( HttpSession httpSession){
        httpSession.setAttribute("user", null);
        String message = "";
        return new ModelAndView("login","message", message);
    }


}
