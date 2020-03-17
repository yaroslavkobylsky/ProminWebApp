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
    private static final String WRONG_LOGIN_OR_PASSWORD_MESSAGE = "wrong login or password!";
    private static final String LOGIN = "login";
    private static final String MESSAGE = "message";
    private static final String USER = "user";
    private static final String HOME = "home";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login() {
        String message = "";
        return new ModelAndView(LOGIN, MESSAGE, message);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView doLogin(String userName, String userPassword, HttpSession httpSession) {
        try {
            User user = userService.getByLoginPass(userName, userPassword);
            if (user == null) {
                return new ModelAndView(LOGIN, MESSAGE, WRONG_LOGIN_OR_PASSWORD_MESSAGE);
            } else {
                httpSession.setAttribute(USER, user);
                return new ModelAndView(HOME);
            }
        } catch (DatabaseException e) {
            LOGGER.error(e);
        }
        return new ModelAndView(LOGIN);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpSession httpSession) {
        httpSession.setAttribute(USER, null);
        String message = "";
        return new ModelAndView(LOGIN, MESSAGE, message);
    }


}
