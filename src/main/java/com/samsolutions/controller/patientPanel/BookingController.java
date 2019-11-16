package com.samsolutions.controller.patientPanel;

import com.samsolutions.service.ScheduleService;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/patientpanel/booking")
@Secured("ROLE_PATIENT")
public class BookingController {

    @Autowired
    UserService userService;

    @Autowired
    ScheduleService scheduleService;

    @RequestMapping(method = RequestMethod.GET, value = "/doctors")
    public String doctorSelect(Model model,
                               @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                               @RequestParam(value = "desc", required = false, defaultValue = "false") Boolean desc,
                               @RequestParam(value = "sort", required = false, defaultValue = "id") String sort) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.addAttribute("patientDataDTO", userService.findByUsername(auth.getName()));
        model.mergeAttributes(userService.getMapAndPageForDoctors(pageNo, pageSize, desc, sort));
        return "/patientpanel/booking/doctors";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String booking(@PathVariable("doctorId") Long doctorId, Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        model.mergeAttributes(scheduleService.bookingPreparation());
        model.addAttribute("patientDataDTO", userService.findByUsername(auth.getName()));
        model.addAttribute("doctorDataDTO", userService.findById(doctorId));
        return "adminpanel/user/details/booking/booking";
    }


}
