package com.samsolutions.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServlet;

@Controller
public class IndexController extends HttpServlet {

    @RequestMapping("/MedRecord")
    public String printIndex(@RequestParam(value = "message",required = false,defaultValue = "Patient")String message, Model model){
        model.addAttribute("message",message);
        return "index";
    }
}
