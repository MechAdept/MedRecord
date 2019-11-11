package com.samsolutions.controller.adminPanel;

import com.samsolutions.service.TicketService;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
@RequestMapping(value = "/adminpanel/ticket")
@Secured("ROLE_ADMIN")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{patientId}/{doctorId}/current", method = RequestMethod.GET)
    public String current(@PathVariable(value = "patientId") Long patientId, @PathVariable(value = "doctorId") Long doctorId, Model model) {
        model.addAttribute("patientDataDTO", userService.findById(patientId));
        model.addAttribute("doctorDataDTO", userService.findById(doctorId));
        model.addAttribute("ticketDataDTO", ticketService.current(patientId, doctorId));
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return "/adminpanel/user/details/tickets/currentTicket";
    }

    @RequestMapping(value = "/{patientId}/{doctorId}/{ticketId}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "patientId") Long patientId,
                         @PathVariable(value = "doctorId") Long doctorId,
                         @PathVariable(value = "ticketId") Long ticketId) {
        ticketService.delete(ticketId);
        return "redirect: /adminpanel/user/" + patientId + "/booking/" + doctorId ;
    }

    @RequestMapping(value = "/{ticketId}", method =  RequestMethod.GET)
    public String read(@PathVariable(value = "ticketId") Long ticketId, Model model){
        model.addAttribute("ticketDataDTO", ticketService.findById(ticketId));
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return "/adminpanel/ticket/details/details";
    }

}