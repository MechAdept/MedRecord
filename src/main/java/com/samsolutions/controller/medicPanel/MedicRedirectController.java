package com.samsolutions.controller.medicPanel;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Secured("ROLE_MEDIC")
@Controller
public class MedicRedirectController {

    @RequestMapping(method = RequestMethod.GET, value = "/medicpanel")
    public String medicPanel() {
        return "redirect:/medicpanel/user";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ROLE_MEDIC")
    public String roleMedic() {
        return "redirect:/medicpanel/user";
    }
}
