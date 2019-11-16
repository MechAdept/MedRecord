package com.samsolutions.controller.patientPanel;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/patientpanel")
@Controller
@Secured("ROLE_PATIENT")
public class ProfileController {

    @RequestMapping(method = RequestMethod.GET, value = "/profile")
    public String profile() {

        return "/patientpanel/profile";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updatephoto")
    public String updatePhoto() {

        return "/patientpanel/profile";
    }
}
