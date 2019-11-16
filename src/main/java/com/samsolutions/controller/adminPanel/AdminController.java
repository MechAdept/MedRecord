package com.samsolutions.controller.adminPanel;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Just one mapping for admin panel.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.controller.adminPanel
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */


@Controller
@Secured("ROLE_ADMIN")
public class AdminController {

    /**
     * Method shows the main page of admin panel.
     *
     * @return returns the admin panel page.
     */
    @RequestMapping(method = RequestMethod.GET,value = "/adminpanel")
    public String adminPanel() {
        return "redirect:/adminpanel/user";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/ROLE_ADMIN")
    public String roleAdmin() {
        return "redirect:/adminpanel/user";
    }
}
