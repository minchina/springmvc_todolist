package com.tw.todolist.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {


    @RequestMapping(value="/login", method = RequestMethod.GET)
    public ModelAndView showLogin(ModelMap model) {
        return new ModelAndView("login");

    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String login(ModelMap model) {

        return reDirect("/loginError");

    }

    @RequestMapping(value="/loginError", method = RequestMethod.GET)
    public String loginError(ModelMap model) {
        model.addAttribute("error", "true");
        return "login";

    }

    private String reDirect(String target) {
        return "redirect:" + target;
    }
}
