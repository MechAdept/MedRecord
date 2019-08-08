package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.HealthDTO;
import com.samsolutions.dto.UserDTO;
import com.samsolutions.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Controller of crud operations for table "health".
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.controller.adminPanel
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Controller
public class HealthController {
    @Autowired
    private HealthService healthService;

    /**
     * Method to create a new health card.
     *
     * @param healthDTO form to create a health card.
     * @return redirects to main page of "health" crud.
     */
    @RequestMapping(value = "/adminpanel/health/create", method = RequestMethod.POST)
    public String create(@ModelAttribute(name = "healthDTO") final HealthDTO healthDTO) {
        healthService.save(healthDTO);
        return "redirect: /adminpanel/health";
    } //Todo: Add patient check


    /**
     * Method to shows records of "health" table.
     *
     * @param model is model.
     * @return return main page of "health" crud.
     */
    @RequestMapping(value = "/adminpanel/health", method = RequestMethod.GET)
    public String read(final Model model) {
        List<HealthDTO> healthDTOList = healthService.getHealths();
        model.addAttribute("userDTOForm", new UserDTO());
        model.addAttribute("healthDTOForm", new HealthDTO());
        model.addAttribute("healthDTOList", healthDTOList);
        return "crud/healthcrud";
    }

    /**
     * Method to shows form for update record of health table.
     *
     * @param model is model.
     * @param id    is id.
     * @return return main page of "health" crud.
     */
    @RequestMapping(value = "/adminpanel/health/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") final Long id, final Model model) {
        HealthDTO healthDTO = healthService.findHealthById(id);
        model.addAttribute("healthDTO", healthDTO);
        model.addAttribute("healthDTOForm", new HealthDTO());
        return "crud/update/healthupdate";
    }

    /**
     * Method for update record of "health" table.
     *
     * @param healthDTO form to update a health card.
     * @return redirects to main page of "health" crud.
     */
    @RequestMapping(value = "adminpanel/health/update", method = RequestMethod.POST)
    public String update(@ModelAttribute final HealthDTO healthDTO) {
        healthService.save(healthDTO);
        return "redirect: /adminpanel/health";
    }

    /**
     * Method to delete record from "health" table.
     *
     * @param id is id.
     * @return redirects to main page of "health" crud.
     */
    @RequestMapping(value = "/adminpanel/health/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") final Long id) {
        healthService.deleteHealth(id);
        return "redirect: /adminpanel/health";
    }
}
