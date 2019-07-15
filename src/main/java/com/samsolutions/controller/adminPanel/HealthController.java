package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.HealthDTO;
import com.samsolutions.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HealthController {
    @Autowired
    private HealthService healthService;

    @RequestMapping(value = "/adminpanel/health/create", method = RequestMethod.POST)
    public String healthCrud(@ModelAttribute(name = "healthDTO") HealthDTO healthDTO, Model model) {
        healthService.save(healthDTO);
        return "redirect: /adminpanel/health";
    }

    @RequestMapping(value = "/adminpanel/health", method = RequestMethod.GET)
    public String healthCrud(Model model) {
        List<HealthDTO> healthDTOList = healthService.gethealths();
        model.addAttribute("healthDTOForm", new HealthDTO());
        model.addAttribute("healthDTOList", healthDTOList);
        return "crud/healthcrud";
    }

    @RequestMapping(value = "/adminpanel/health/update/{id}", method = RequestMethod.GET)
    public String healthUpdate(@PathVariable("id") Long id, Model model) {
        HealthDTO healthDTO = healthService.findHealthById(id);
        model.addAttribute("healthDTO", healthDTO);
        model.addAttribute("healthDTOForm", new HealthDTO());
        return "crud/update/healthupdate";
    }

    @RequestMapping(value = "adminpanel/health/update", method = RequestMethod.POST)
    public String healthUpdate(@ModelAttribute HealthDTO healthDTO, Model model) {
        healthService.update(healthDTO);
        return "redirect: /adminpanel/health";
    }

    @RequestMapping(value = "/adminpanel/health/delete/{id}", method = RequestMethod.GET)
    public String healthCrud(@PathVariable("id") Long id, Model model) {
        healthService.deleteHealth(id);
        return "redirect: /adminpanel/health";
    }
}
