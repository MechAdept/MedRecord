package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.HealthDTO;
import com.samsolutions.dto.data.UserDTO;
import com.samsolutions.service.HealthService;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller of crud operations for table "health".
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.controller.adminPanel
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Controller
@RequestMapping(value = "/adminpanel/health")
@PreAuthorize("isAuthenticated()")
public class HealthController {
    @Autowired
    private HealthService healthService;

    @Autowired
    private UserService userService;

    /**
     * Method to create a new health card.
     *
     * @return redirects to main page of "health" crud.
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("healthDTOForm") HealthDTO healthDTOForm, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "adminpanel/health/create";
        }
        healthDTOForm.setPatient(userService.findWithRolesById(healthDTOForm.getPatientId()));
        healthDTOForm.setBirth(healthDTOForm.getBirthString());
        healthDTOForm.setPhoto(healthDTOForm.getPhoto());
        healthService.save(healthDTOForm);

        UserDTO userDTO = userService.findWithRolesById(healthDTOForm.getPatientId());
        model.addAttribute("userDTO", userDTO);
        return "/adminpanel/user/details/details";
    }

    @RequestMapping(value = "/create/{id}", method = RequestMethod.GET)
    public String create(@PathVariable(value = "id") Long id, Model model) {
        if (id != null) {
            model.addAttribute("userDTO", userService.findById(id));
        }

        HealthDTO healthDTO = new HealthDTO();
        healthDTO.setPatient(new UserDTO());
        model.addAttribute("healthDTOForm", healthDTO);
        return "/adminpanel/health/create";
    }

    /**
     * Method to shows form for update record of health table.
     *
     * @param model is model.
     * @param id    is id.
     * @return return main page of "health" crud.
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") final Long id, final Model model) {
        HealthDTO healthDTO = healthService.findHealthById(id);
        model.addAttribute("healthDTO", healthDTO);
        return "adminpanel/health/edit";
    }

    /**
     * Method for edit record of "health" table.
     *
     * @return redirects to main page of "health" crud.
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("healthDTOForm") HealthDTO healthDTOForm, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "adminpanel/health/edit";
        }
        healthDTOForm.setPatient(userService.findWithRolesById(healthDTOForm.getPatientId()));
        healthDTOForm.setBirth(healthDTOForm.getBirthString());
        healthDTOForm.setPhoto(healthDTOForm.getPhoto());
        healthService.save(healthDTOForm);
        UserDTO userDTO = userService.findWithRolesById(healthDTOForm.getPatientId());
        model.addAttribute("userDTO", userDTO);
        return "/adminpanel/user/details/details";
    }

    /**
     * Method to delete record from "health" table.
     *
     * @param id is id.
     * @return redirects to main page of "health" crud.
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") final Long id) {
        healthService.deleteHealth(id);
        return "redirect:/adminpanel/health/create";
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable("id") final Long id, Model model) {
        model.addAttribute("healthDTO", healthService.findHealthById(id));
        return "adminpanel/health/details";
    }

    @RequestMapping(value = "/details/patient/{id}", method = RequestMethod.GET)
    public String detailsPatient(@PathVariable("id") final Long id, Model model) {
        model.addAttribute("userDTO", userService.findById(id));
        return "/adminpanel/user/details/details";
    }
}
