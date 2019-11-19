package com.samsolutions.controller.patientPanel;

import com.samsolutions.dto.data.VisitDataDTO;
import com.samsolutions.service.TicketService;
import com.samsolutions.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/patientpanel/visit")
@Secured("ROLE_PATIENT")
public class PatientVisitController {

    @Autowired
    VisitService visitService;

    @Autowired
    TicketService ticketService;

    @RequestMapping(method = RequestMethod.GET, value = "/{ticketId}")
    public String details(@PathVariable("ticketId") final Long ticketId, Model model) {
        VisitDataDTO visitDataDTO = visitService.findByTicketId(ticketId);
        if (visitDataDTO.getId() != null) {
            model.addAttribute("visitDataDTO", visitDataDTO);
            model.addAttribute("ticketDataDTO", ticketService.findById(ticketId));
            model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            return "patientpanel/ticket/visit";
        } else {
            return "redirect: /patientpanel/ticket/" + ticketId;
        }
    }
}
