package com.samsolutions.controller.adminPanel;

import com.samsolutions.service.ScheduleService;
import com.samsolutions.service.TicketService;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Secured("ROLE_ADMIN")
@RequestMapping("/adminpanel/schedule")
public class AdminScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    TicketService ticketService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{patientId}/doctors", method = RequestMethod.GET)
    public String doctorsForBooking(Model model, @PathVariable(name = "patientId") final Long patientId,
                                    @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                                    @RequestParam(value = "desc", required = false, defaultValue = "false") Boolean desc,
                                    @RequestParam(value = "sort", required = false, defaultValue = "id") String sort) {
        model.addAttribute("patientDataDTO",userService.findById(patientId));
        model.mergeAttributes(userService.getMapAndPageForDoctors(pageNo, pageSize, desc, sort));
        return "/adminpanel/user/details/booking/doctors";
    }


    @RequestMapping(value = "/{patientId}/booking/{doctorId}", method = RequestMethod.GET)
    public String booking(@PathVariable("patientId") final Long patientId, @PathVariable("doctorId") Long doctorId, Model model) {
        model.mergeAttributes(scheduleService.bookingPreparation());
        model.addAttribute("patientDataDTO", userService.findById(patientId));
        model.addAttribute("doctorDataDTO", userService.findById(doctorId));
        return "adminpanel/user/details/booking/scheduleBooking";
    }

    @RequestMapping(value = "/{doctorId}/readSchedule", method = RequestMethod.GET)
    public String scheduleDetails(@PathVariable("doctorId") final Long doctorId, Model model) {
        model.mergeAttributes(scheduleService.bookingPreparation());
        model.addAttribute("doctorDataDTO", userService.findById(doctorId));
        return "adminpanel/user/details/booking/scheduleDetails";
    }

    @RequestMapping(value = "/{doctorId}/editSchedule", method = RequestMethod.GET)
    public String scheduleEdit(@PathVariable("doctorId") final Long doctorId, Model model) {
        model.mergeAttributes(scheduleService.bookingPreparation());
        model.addAttribute("doctorDataDTO", userService.findById(doctorId));
        return "adminpanel/user/details/booking/scheduleEdit";
    }

}
