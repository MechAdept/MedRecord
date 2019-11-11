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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@Secured("ROLE_ADMIN")
public class ScheduleController {

    @Autowired
    ScheduleService scheduleService;

    @Autowired
    TicketService ticketService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/adminpanel/schedule/{pid}/doctors", method = RequestMethod.GET)
    public String doctorsForBooking(Model model, @PathVariable(name = "pid") final Long pid,
                                    @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                                    @RequestParam(value = "desc", required = false, defaultValue = "false") Boolean desc,
                                    @RequestParam(value = "sort", required = false, defaultValue = "id") String sort) {
        model.addAttribute(userService.findById(pid));
        model.mergeAttributes(userService.getMapAndPageForDoctors(pageNo, pageSize, desc, sort));
        model.addAttribute(userService.findById(pid));
        return "/adminpanel/user/details/booking/doctors";
    }


    @RequestMapping(value = "/adminpanel/user/{pid}/booking/{did}", method = RequestMethod.GET)
    public String booking(@PathVariable("pid") final Long pid, @PathVariable("did") Long did, Model model) {
        model.mergeAttributes(bookingPreparation(pid, did));
        return "adminpanel/user/details/booking/booking";
    }

    @RequestMapping(value = "/adminpanel/user/{pid}/readBooking/", method = RequestMethod.GET)
    public String bookingRead(@PathVariable("did") final Long did, Model model) {
        model.mergeAttributes(readAndEditPreparation(did));
        return "/adminpanel/user/details/booking/readBooking";
    }

    @RequestMapping(value = "/adminpanel/user/{did}/edit", method = RequestMethod.GET)
    public String bookingEdit(@PathVariable("did") final Long doctorId, Model model) {
        model.mergeAttributes(readAndEditPreparation(doctorId));
        return "/adminpanel/user/details/booking/editBooking";
    }

    private Map<String, Object> bookingPreparation(Long patientId, Long doctorId) {
        Map<String, Object> map = schedulePreparation();
        map.put("patientDataDTO", userService.findById(patientId));
        map.put("doctorDataDTO", userService.findById(doctorId));
        return map;
    }

    private Map<String, Object> readAndEditPreparation(Long doctorId) {
        Map<String, Object> map = schedulePreparation();
        map.put("doctorDataDTO", userService.findById(doctorId));
        return map;
    }

    private Map<String, Object> schedulePreparation() {
        Map<String, Object> map = new HashMap<>();
        Date currentDate = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        c.add(Calendar.MONTH, 1);
        map.put("formatter", new SimpleDateFormat("yyyy-MM-dd"));
        map.put("currentDate", currentDate);
        map.put("maxDate", c.getTime());
        return map;
    }
}
