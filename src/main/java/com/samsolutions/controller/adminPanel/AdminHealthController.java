package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.data.HealthDataDTO;
import com.samsolutions.dto.form.HealthFormDTO;
import com.samsolutions.service.HealthService;
import com.samsolutions.service.UserService;
import com.samsolutions.validator.health.HealthValidator;
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
public class AdminHealthController {

    @Autowired
    private HealthService healthService;

    @Autowired
    private UserService userService;

    @Autowired
    private HealthValidator healthValidator;

    @RequestMapping(value = "/{userId}/create", method = RequestMethod.GET)
    public String create(@PathVariable(value = "patientId") Long patientId, Model model) {
        model.addAttribute("userDataDTO", userService.findById(patientId));
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
        healthValidator.validate(healthFormDTO, bindingResult);
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
     * @param patientId    is id.
     * @return return main page of "health" crud.
     */
    @RequestMapping(value = "/{patientId}/edit", method = RequestMethod.GET)
    public String edit(@PathVariable("patientId") final Long patientId, final Model model) {
        HealthDataDTO healthDataDTO = healthService.findByPatientId(patientId);
        model.addAttribute("userDataDTO", userService.findById(patientId));
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
        healthValidator.validate(healthFormDTO, bindingResult);
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
     * @param patientId is id.
     * @return redirects to main page of "health" crud.
     */
    @RequestMapping(value = "/{patientId}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable("patientId") final Long patientId) {
        healthService.delete(patientId);
        return "redirect: /adminpanel/user/details/" + patientId + "/health";
    }

    @RequestMapping(value = "/{patientId}", method = RequestMethod.GET)
    public String details(@PathVariable("patientId") final Long patientId, Model model) {
        model.addAttribute("healthDataDTO", healthService.findById(patientId));
        model.addAttribute("userDataDTO", userService.findById(patientId));
        return "adminpanel/user/details/health/details";
    }
}
