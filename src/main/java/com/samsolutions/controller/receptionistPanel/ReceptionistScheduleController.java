package com.samsolutions.controller.receptionistPanel;

import com.samsolutions.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Secured("ROLE_RECEPTIONIST")
@RequestMapping("/receptionistpanel/schedule")
public class ReceptionistScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(method = RequestMethod.GET, value = "/{doctorId}")
    public String scheduleEdit(@PathVariable("doctorId") final Long doctorId) {

        return "";
    }

}