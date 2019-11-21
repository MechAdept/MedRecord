package com.samsolutions.controller.patientPanel;

import com.samsolutions.dto.data.TicketDataDTO;
import com.samsolutions.dto.data.UserDataDTO;
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

@Controller
@Secured("ROLE_PATIENT")
@RequestMapping("/patientpanel")
public class PatientTicketController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/tickets")
    public String list(Model model, @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                       @RequestParam(value = "desc", required = false, defaultValue = "false") Boolean desc,
                       @RequestParam(value = "sort", required = false, defaultValue = "id") String sort) {
        UserDataDTO currentUser = userService.getCurrent();
        model.mergeAttributes(ticketService.getMapAndPageByUser(currentUser.getId(), pageNo, pageSize, desc, sort));
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        model.addAttribute("userDataDTO", userService.findById(currentUser.getId()));
        return "/patientpanel/ticket/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ticket/{doctorId}/current")
    public String currentDetails(@PathVariable(value = "doctorId") final Long doctorId) {
        Long currentTicketId = ticketService.current(userService.getCurrent().getId(), doctorId).getId();
        return "redirect: /patientpanel/ticket/" + currentTicketId;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ticket/{ticketId}")
    public String details(Model model, @PathVariable(value = "ticketId") final Long ticketId) {
        TicketDataDTO ticketDataDTO = ticketService.findById(ticketId);
        model.addAttribute("ticketDataDTO", ticketDataDTO);
        model.addAttribute("patientDataDTO", ticketDataDTO.getPatient());
        model.addAttribute("doctorDataDTO", ticketDataDTO.getDoctor());
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return "/patientpanel/ticket/details";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/ticket/{ticketId}/delete")
    public String delete(@PathVariable(value = "ticketId") final Long ticketId) {
        ticketService.delete(ticketId);
        return "redirect:/patientpanel/tickets";
    }
}