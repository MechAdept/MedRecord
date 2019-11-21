package com.samsolutions.controller.receptionistPanel;

import com.samsolutions.service.ScheduleService;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Secured("ROLE_RECEPTIONIST")
@RequestMapping("/receptionistpanel/schedule")
public class ReceptionistScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/{doctorId}")
    public String scheduleEdit(@PathVariable("doctorId") final Long doctorId, Model model) {
        model.mergeAttributes(scheduleService.bookingPreparation());
        model.addAttribute("doctorDataDTO", userService.findById(doctorId));
        return "/receptionistpanel/scheduleUpdate";
    }

}