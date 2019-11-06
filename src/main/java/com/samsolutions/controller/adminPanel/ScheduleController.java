package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.data.TicketDataDTO;
import com.samsolutions.dto.data.UserDataDTO;
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
import java.util.Date;

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
//        TicketDataDTO ticketDataDTO = ticketService.current(pid,did);
//        if(ticketDataDTO != null){
//            return "redirect: /adminpanel/ticket/" + pid + "/" + did + "/current";
//        }
        model.addAttribute("patientDataDTO", userService.findById(pid));
        model.addAttribute("doctorDataDTO", userService.findById(did));
        model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
        model.addAttribute("currentDate", new Date());
        return "adminpanel/user/details/booking/booking";
    }

    @RequestMapping(value = "/adminpanel/user/{pid}/read/", method = RequestMethod.GET)
    public String bookingRead(@PathVariable("pid") final Long pid, @PathVariable("did") final Long did, Model model) {
        model.addAttribute(userService.findById(pid));
        model.addAttribute(userService.findById(did));
        return "/adminpanel/user/details/booking/readBooking";
    }

    @RequestMapping(value = "/adminpanel/user/{id}/edit", method = RequestMethod.GET)
    public String bookingEdit(@PathVariable("id") final Long id, Model model) {
        return "/adminpanel/user/details/booking/editBooking";
    }
}
