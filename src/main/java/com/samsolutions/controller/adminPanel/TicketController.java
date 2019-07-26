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

/**
 * Controller of crud operations for table "ticket".
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.controller.adminPanel
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Controller
public class TicketController {
    @Autowired
    private TicketService ticketService;

    /**
     * Method to create a new ticket.
     *
     * @param ticketDTO form to create a ticket.
     * @return redirects to main page of "ticket" crud.
     */
    @RequestMapping(value = "/adminpanel/ticket/create", method = RequestMethod.POST)
    public String create(@ModelAttribute(name = "ticketDTO") final TicketDTO ticketDTO) {
        ticketService.save(ticketDTO);
        return "redirect: /adminpanel/ticket";
    }

    /**
     * Method to shows records of "ticket" table.
     *
     * @param model is model.
     * @return return main page of "ticket" crud.
     */
    @RequestMapping(value = "/adminpanel/ticket", method = RequestMethod.GET)
    public String read(final Model model) {
        List<TicketDTO> ticketDTOList = ticketService.getTickets();
        model.addAttribute("ticketDTOForm", new TicketDTO());
        model.addAttribute("ticketDTOList", ticketDTOList);
        return "crud/ticketcrud";
    }

    /**
     * Method to shows form for update record of ticket table.
     *
     * @param model is model.
     * @param id    is id.
     * @return return main page of "ticket" crud.
     */
    @RequestMapping(value = "/adminpanel/ticket/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") final Long id, final Model model) {
        TicketDTO ticketDTO = ticketService.findTicketById(id);
        model.addAttribute("ticketDTO", ticketDTO);
        model.addAttribute("ticketDTOForm", new TicketDTO());
        return "crud/update/ticketupdate";
    }

    /**
     * Method for update record of "ticket" table.
     *
     * @param ticketDTO form to update a ticket.
     * @return redirects to main page of "ticket" crud.
     */
    @RequestMapping(value = "adminpanel/ticket/update", method = RequestMethod.POST)
    public String update(@ModelAttribute final TicketDTO ticketDTO) {
        ticketService.update(ticketDTO);
        return "redirect: /adminpanel/ticket";
    }

    /**
     * Method to delete record from "ticket" table.
     *
     * @param id is id.
     * @return redirects to main page of "ticket" crud.
     */
    @RequestMapping(value = "/adminpanel/ticket/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") final Long id) {
        ticketService.deleteTicket(id);
        return "redirect: /adminpanel/ticket";
    }
}