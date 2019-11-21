package com.samsolutions.controller.medicPanel;

import com.samsolutions.dto.data.VisitDataDTO;
import com.samsolutions.dto.form.VisitFormDTO;
import com.samsolutions.service.TicketService;
import com.samsolutions.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@Secured("ROLE_MEDIC")
@RequestMapping("/medicpanel/visit")
public class MedicVisitController {

    @Autowired
    private VisitService visitService;

    @Autowired
    private TicketService ticketService;


    @RequestMapping(method = RequestMethod.GET, value = "/{ticketId}")
    public String details(@PathVariable("ticketId") final Long ticketId, Model model) {
        VisitDataDTO visitDataDTO = visitService.findByTicketId(ticketId);
        if (visitDataDTO.getId() != null) {
            model.addAttribute("visitDataDTO", visitDataDTO);
            model.addAttribute("ticketDataDTO", ticketService.findById(ticketId));
            model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            return "/medicpanel/ticket/visit/details";
        } else {
            return "redirect:/medicpanel/visit/" + ticketId +"/start";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{ticketId}/start")
    public String startVisit(@PathVariable("ticketId") final Long ticketId, Model model) {
        VisitDataDTO visitDataDTO = visitService.findByTicketId(ticketId);
        if(visitDataDTO.getId() != null){
            return "redirect:/medicpanel/visit/" + ticketId;
        }
        model.addAttribute("ticketDataDTO", ticketService.findById(ticketId));
        VisitFormDTO visitFormDTO = new VisitFormDTO();
        visitFormDTO.setDatetime(LocalDateTime.now().toString());
        model.addAttribute("visitFormDTO", visitFormDTO);
        return "/medicpanel/ticket/visit/create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save")
    public String save(@ModelAttribute final VisitFormDTO visitFormDTO, Model model) {
        visitService.save(visitFormDTO);
        model.addAttribute("visitDataDTO", visitService.findByTicketId(visitFormDTO.getTicketId()));
        model.addAttribute("ticketDataDTO",ticketService.findById(visitFormDTO.getTicketId()));
        return "redirect:/medicpanel/visit/" + visitFormDTO.getTicketId();
    }
}
