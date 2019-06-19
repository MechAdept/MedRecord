package com.samsolutions.controllers;

import com.samsolutions.entity.User;
import com.samsolutions.entity.UserForm;
import com.samsolutions.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class LoginController {
    UserService userService;



















//    @PostMapping("/login")
//    public String login(@ModelAttribute(name = "userForm") UserForm userForm, Model model) {
////        userService.findById(userForm.getLogin());
//        model.addAttribute("userForm", new UserForm());
//        return "login";
//    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "login";
    }


    @PostMapping("/submit")
    public String login(@ModelAttribute(name = "userForm") UserForm userForm, Model model){
        model.addAttribute("userForm", new UserForm());
        return "mainPage";
    }
}
