package com.samsolutions.controller.medicPanel;

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

@Controller
@Secured("ROLE_MEDIC")
@RequestMapping("/medicpanel/health")
public class MedicHealthController {

    @Autowired
    UserService userService;

    @Autowired
    HealthService healthService;

    @Autowired
    HealthValidator healthValidator;

    @RequestMapping(method = RequestMethod.GET, value = "/{patientId}")
    public String details(@PathVariable("patientId") final Long patientId, Model model) {
        model.addAttribute("healthDataDTO", healthService.findByPatientId(patientId));
        model.addAttribute("userDataDTO", userService.findById(patientId));
        return "/medicpanel/health/details";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{patientId}/update")
    public String update(@PathVariable("patientId") final Long patientId, Model model) {
        HealthDataDTO healthDataDTO = healthService.findByPatientId(patientId);
        model.addAttribute("userDataDTO", userService.findById(patientId));
        model.addAttribute("healthFormDTO", new HealthFormDTO());
        model.addAttribute("healthDataDTO", healthDataDTO);
        return "/medicpanel/health/update";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public String update(@ModelAttribute final HealthFormDTO healthFormDTO, BindingResult bindingResult, Model model) {
        healthValidator.validate(healthFormDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDataDTO", userService.findById(healthFormDTO.getPatientId()));
            model.addAttribute("healthFormDTO", new HealthFormDTO());
            model.addAttribute("healthDataDTO", healthService.findByPatientId(healthFormDTO.getPatientId()));
            return "/medicpanel/health/update";
        }
        healthService.save(healthFormDTO);
        return "redirect:/medicpanel/health/" + healthFormDTO.getPatientId();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{patientId}/create")
    public String create(@PathVariable("patientId") final Long patientId, Model model) {
        model.addAttribute("userDataDTO", userService.findById(patientId));
        model.addAttribute("healthFormDTO", new HealthFormDTO());
        model.addAttribute("healthFormDTO", new HealthFormDTO());
        return "/medicpanel/health/create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String create(@ModelAttribute("healthFormDTO") final HealthFormDTO healthFormDTO, BindingResult bindingResult, Model model) {
        healthValidator.validate(healthFormDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDataDTO", userService.findById(healthFormDTO.getPatientId()));
            model.addAttribute("healthFormDTO", healthFormDTO);
            return "/medicpanel/health/create";
        }
        healthService.save(healthFormDTO);
        return "redirect:/medicpanel/health/" + healthFormDTO.getPatientId();
    }
}
