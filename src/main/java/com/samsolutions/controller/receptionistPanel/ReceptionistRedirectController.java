package com.samsolutions.controller.receptionistPanel;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Secured("ROLE_RECEPTIONIST")
@RequestMapping("/receptionistpanel")
public class ReceptionistRedirectController {

    @RequestMapping(method = RequestMethod.GET, value = "/receptionistpanel")
    public String receptionistPanel() {
        return "";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ROLE_RECEPTIONIST")
    public String roleReceptionist() {
        return "";
    }
}
