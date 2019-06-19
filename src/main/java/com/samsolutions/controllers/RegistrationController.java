package com.samsolutions.controllers;

import com.samsolutions.entity.User;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String printView(Model model) {
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping(value = "/create-submit")
    public String createUser(@ModelAttribute(name = "user") User user, Model model) {
        userService.createUser(user);
        printView(model);
        return "registration";
    }

    @GetMapping(value = "/create-submit")
    public String createUser(Model model) {
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("user", new User());
        return "registration";
    }

    @GetMapping(value = "/delete")
    public String deleteUser(@RequestParam(value = "id",required = false)Integer id,  Model model) {
        userService.delete(id);
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("user", new User());
        return "registration";
    }
}