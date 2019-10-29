package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.data.HealthDataDTO;
import com.samsolutions.dto.form.HealthFormDTO;
import com.samsolutions.service.HealthService;
import com.samsolutions.service.UserService;
import com.samsolutions.validator.health.HealthCreateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
@Secured("ROLE_ADMIN")
public class HealthController {

    @Autowired
    private HealthService healthService;

    @Autowired
    private UserService userService;

    @Autowired
    private HealthCreateValidator healthCreateValidator;

    @RequestMapping(value = "/{id}/create", method = RequestMethod.GET)
    public String create(@PathVariable(value = "id") Long id, Model model) {
        model.addAttribute("userDataDTO", userService.findById(id));
        model.addAttribute("healthFormDTO", new HealthFormDTO());
        model.addAttribute("healthFormDTO", new HealthFormDTO());
        return "/adminpanel/user/details/health/create";
    }

    /**
     * Method to create a new health card.
     *
     * @return redirects to main page of "health" crud.
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("healthFormDTO") final HealthFormDTO healthFormDTO,
                         final BindingResult bindingResult, final Model model) {
        healthCreateValidator.validate(healthFormDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDataDTO", userService.findById(healthFormDTO.getPatientId()));
            model.addAttribute("healthFormDTO", healthFormDTO);
            return "/adminpanel/user/details/health/create";
        }
        healthService.save(healthFormDTO);
        return "redirect: /adminpanel/user/details/" + healthFormDTO.getPatientId();
    }

    /**
     * Method to shows form for update record of health table.
     *
     * @param model is model.
     * @param id    is id.
     * @return return main page of "health" crud.
     */
    @RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable("id") final Long id, final Model model) {
        HealthDataDTO healthDataDTO = healthService.findByPatientId(id);
        model.addAttribute("userDataDTO", userService.findById(id));
        model.addAttribute("healthFormDTO", new HealthFormDTO());
        model.addAttribute("healthDataDTO", healthDataDTO);
        return "/adminpanel/user/details/health/edit";
    }

    /**
     * Method for edit record of "health" table.
     *
     * @return redirects to main page of "health" crud.
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("healthDTOForm") HealthFormDTO healthFormDTO, BindingResult bindingResult, final Model model) {
        healthCreateValidator.validate(healthFormDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDataDTO", userService.findById(healthFormDTO.getPatientId()));
            model.addAttribute("healthFormDTO", new HealthFormDTO());
            model.addAttribute("healthDataDTO", healthService.findByPatientId(healthFormDTO.getPatientId()));
            return "/adminpanel/user/details/health/edit";
        }
        healthService.save(healthFormDTO);
        return "redirect: /adminpanel/user/details/" + healthFormDTO.getPatientId() + "/health";
    }

    /**
     * Method to delete record from "health" table.
     *
     * @param id is id.
     * @return redirects to main page of "health" crud.
     */
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("id") final Long id) {
        healthService.deleteHealthByPatientId(id);
        return "redirect: /adminpanel/user/details/" + id + "/health";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String details(@PathVariable("id") final Long id, Model model) {
        model.addAttribute("healthDTO", healthService.findById(id));
        return "/adminpanel/user/details/health/read";
    }
}
