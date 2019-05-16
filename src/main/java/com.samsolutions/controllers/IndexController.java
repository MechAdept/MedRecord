package com.samsolutions.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("")
@Controller
public class IndexController {

    @RequestMapping(method = RequestMethod.GET)
    public String printIndex(ModelMap model){
        model.addAttribute("message","Index");
        return "Index";
    }
}
