package com.samsolutions.controller.medicPanel;

import com.samsolutions.service.ScheduleService;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/medicpanel/schedule")
@Secured("ROLE_MEDIC")
public class MedicScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String scheduleDetails(Model model) {
        model.mergeAttributes(scheduleService.bookingPreparation());
        model.addAttribute("doctorDataDTO", userService.getCurrent());
        return "/medicpanel/booking/scheduleDetails";
    }


}
