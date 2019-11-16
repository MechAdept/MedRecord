package com.samsolutions.controller.patientPanel;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Secured("ROLE_PATIENT")
@Controller
public class PatientController {

    @RequestMapping(method = RequestMethod.GET, value = "/patientpanel")
    public String patientPanel() {
        return "redirect: /patientpanel/profile";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ROLE_PATIENT")
    public String rolePatient() {
        return "redirect: /patientpanel/profile";
    }
}
