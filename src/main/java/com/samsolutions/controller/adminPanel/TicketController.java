package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.TicketDTO;
import com.samsolutions.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/adminpanel/ticket/create", method = RequestMethod.POST)
    public String ticketCrud(@ModelAttribute(name = "ticketDTO") TicketDTO ticketDTO) {
        ticketService.save(ticketDTO);
        return "redirect: /adminpanel/ticket";
    }

    @RequestMapping(value = "/adminpanel/ticket", method = RequestMethod.GET)
    public String ticketCrud(Model model) {
        List<TicketDTO> ticketDTOList = ticketService.getTickets();
        model.addAttribute("ticketDTOForm", new TicketDTO());
        model.addAttribute("ticketDTOList", ticketDTOList);
        return "crud/ticketcrud";
    }

    @RequestMapping(value = "/adminpanel/ticket/update/{id}", method = RequestMethod.GET)
    public String ticketUpdate(@PathVariable("id") Long id, Model model) {
        TicketDTO ticketDTO = ticketService.findTicketById(id);
        model.addAttribute("ticketDTO", ticketDTO);
        model.addAttribute("ticketDTOForm", new TicketDTO());
        return "crud/update/ticketupdate";
    }

    @RequestMapping(value = "adminpanel/ticket/update", method = RequestMethod.POST)
    public String ticketUpdate(@ModelAttribute TicketDTO ticketDTO) {
        ticketService.update(ticketDTO);
        return "redirect: /adminpanel/ticket";
    }

    @RequestMapping(value = "/adminpanel/ticket/delete/{id}", method = RequestMethod.GET)
    public String ticketCrud(@PathVariable("id") Long id) {
        ticketService.deleteTicket(id);
        return "redirect: /adminpanel/ticket";
    }
}