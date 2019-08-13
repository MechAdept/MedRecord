package com.samsolutions.controller.adminPanel;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/adminpanel")
public class AdminController {

    /**
     * Method shows the main page of admin panel.
     *
     * @param model the model.
     * @return returns the admin panel page.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String adminPanel(final Model model) {
        return "adminpanel/adminPanel";
    }

}
