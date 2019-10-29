package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.data.TicketDataDTO;
import com.samsolutions.dto.form.TicketFormDTO;
import com.samsolutions.service.TicketService;
import com.samsolutions.service.UserService;
import com.samsolutions.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;

/**
 * Controller of crud operations for table "ticket".
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.controller.adminPanel
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Controller
@RequestMapping("/adminpanel/ticket")
@Secured("ROLE_ADMIN")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{patientId}/{doctorId}/current", method = RequestMethod.GET)
    public String doctorsForBooking(@PathVariable(value = "patientId") Long patientId, @PathVariable(value = "doctorId") Long doctorId, Model model) {
        model.addAttribute("patientDataDTO", userService.findById(patientId));
        model.addAttribute("ticketDataDTO",ticketService.current(patientId,doctorId));
        return "/adminpanel/user/details/booking/doctors";
    }

}