package com.samsolutions.controller.patientPanel;

import com.samsolutions.service.HealthService;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Secured("ROLE_PATIENT")
@RequestMapping("/patientpanel/health")
public class PatientHealthController {

    @Autowired
    HealthService healthService;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String details(Model model) {
        model.addAttribute("healthDataDTO", healthService.getCurrent());
        model.addAttribute("userDataDTO", userService.getCurrent());
        return "patientpanel/user/health";
    }
}
