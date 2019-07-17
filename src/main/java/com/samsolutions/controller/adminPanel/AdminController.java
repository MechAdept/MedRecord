package com.samsolutions.controller.adminPanel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AdminController {

    @RequestMapping(value = "/adminpanel", method = RequestMethod.GET)
    public String adminPanel(Model model) {
        return "adminPanel";
    }


}
