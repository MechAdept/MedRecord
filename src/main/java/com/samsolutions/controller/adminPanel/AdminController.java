package com.samsolutions.controller.adminPanel;

import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/adminpanel", method = RequestMethod.GET)
    public String adminPanel(Model model) {
        return "adminPanel";
    }



}
