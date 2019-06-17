package com.samsolutions.controllers;

import com.samsolutions.entity.User;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String printIndex(Model model) {
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("user", new User());
//        List<User> userList = user.;
//        model.addAttribute(user);
        return "registration";
    }

    @RequestMapping(value = "/registration-submit", method = RequestMethod.POST)
    public String printIndex(@ModelAttribute(name = "user") User user, Model model) {
        model.addAttribute("user", user);
//        List<User> userList = user.;
//        model.addAttribute(user);
        return "registration";
    }

    @RequestMapping(value = "/delete-submit", method = RequestMethod.POST)
    public String printIndex(@ModelAttribute(name = "user") User user) {
//        List<User> userList = user.;
//        model.addAttribute(user);
        return "registration";
    }
}