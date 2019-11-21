package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.data.TicketDataDTO;
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
public class AdminTicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{patientId}/{doctorId}/current", method = RequestMethod.GET)
    public String current(@PathVariable(value = "patientId") Long patientId, @PathVariable(value = "doctorId") Long doctorId, Model model) {
        model.addAttribute("patientDataDTO", userService.findById(patientId));
        model.addAttribute("doctorDataDTO", userService.findById(doctorId));
        model.addAttribute("ticketDataDTO", ticketService.current(patientId, doctorId));
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return "adminpanel/user/details/ticket/details";
    }

    @RequestMapping(value = "/{patientId}/{doctorId}/{ticketId}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "patientId") Long patientId,
                         @PathVariable(value = "doctorId") Long doctorId,
                         @PathVariable(value = "ticketId") Long ticketId) {
        ticketService.delete(ticketId);
        return "redirect: /adminpanel/user/" + patientId + "/booking/" + doctorId;
    }

    @RequestMapping(value = "/{ticketId}", method = RequestMethod.GET)
    public String read(@PathVariable(value = "ticketId") Long ticketId, Model model) {
        TicketDataDTO ticketDataDTO = ticketService.findById(ticketId);
        model.addAttribute("ticketDataDTO", ticketDataDTO);
        model.addAttribute("doctorDataDTO", ticketDataDTO.getDoctor());
        model.addAttribute("patientDataDTO", ticketDataDTO.getPatient());
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return "adminpanel/user/details/ticket/details";
    }

    @RequestMapping(value = "/{userId}/list", method = RequestMethod.GET)
    public String userTickets(Model model, @PathVariable(value = "userId") final Long userId,
                              @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                              @RequestParam(value = "desc", required = false, defaultValue = "false") Boolean desc,
                              @RequestParam(value = "sort", required = false, defaultValue = "id") String sort) {
        model.mergeAttributes(ticketService.getMapAndPageByUser(userId, pageNo, pageSize, desc, sort));
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        model.addAttribute("userDataDTO", userService.findById(userId));
        return "adminpanel/user/details/ticket/list";
    }
}