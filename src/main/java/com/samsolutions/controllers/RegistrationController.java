package com.samsolutions.controllers;

//import com.samsolutions.dao.UserDAO;
import com.samsolutions.entity.User;
import com.samsolutions.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RegistrationController{
    @RequestMapping("/adminpanel")
    public String printIndex(@RequestParam(value = "Table",required = false) User user, Model model){
//        List<User> userList =;
        model.addAttribute(user);
        return "adminpanel";
    }
}