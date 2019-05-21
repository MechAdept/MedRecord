package com.samsolutions.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController{
    @RequestMapping("/")
    public String printIndex(@RequestParam(value = "message",required = false,defaultValue = "Patient")String message, Model model){
        model.addAttribute("message",message);
        return "index";
    }
}