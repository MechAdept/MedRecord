package com.samsolutions.controller.patientPanel;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Secured("ROLE_PATIENT")
@RequestMapping("/patientpanel/health")
public class OwnHealthController {

    @RequestMapping(method = RequestMethod.GET)
    public String viewHealth(){

        return "/patientpanel/health";
    }
}
