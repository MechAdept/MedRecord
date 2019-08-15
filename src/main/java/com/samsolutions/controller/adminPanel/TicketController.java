package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.TicketDTO;
import com.samsolutions.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
@RequestMapping("/adminpanel/ticket")
@Secured("ROLE_ADMIN")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    /**
     * Method to create a new ticket.
     *
     * @param ticketDTO form to create a ticket.
     * @return redirects to main page of "ticket" crud.
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@ModelAttribute(name = "ticketDTO") final TicketDTO ticketDTO) {
        ticketService.save(ticketDTO);
        return "/adminpanel/ticket/create";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String read(final Model model,
                                @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                                @RequestParam(value = "desc", required = false, defaultValue = "true") Boolean desc,
                                @RequestParam(value = "sort", required = false, defaultValue = "datetime") String sort) {
        model.addAttribute("DTOList", ticketService.getPage(pageNo - 1, pageSize, desc, sort));
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("desc", desc);
        model.addAttribute("sort", sort);
        model.addAttribute("pageCount", ticketService.getPageCount(pageSize));
        model.addAttribute("elementsCount", ticketService.getTotalCount());
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return "/adminpanel/ticket/crud";
    }

    /**
     * Method to shows form for update record of ticket table.
     *
     * @param model is model.
     * @param id    is id.
     * @return return main page of "ticket" crud.
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") final Long id, final Model model) {
        TicketDTO ticketDTO = ticketService.findTicketById(id);
        model.addAttribute("ticketDTO", ticketDTO);
        model.addAttribute("ticketDTOForm", new TicketDTO());
        return "adminpanel/ticket/update";
    }

    /**
     * Method for update record of "ticket" table.
     *
     * @param ticketDTO form to update a ticket.
     * @return redirects to main page of "ticket" crud.
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute final TicketDTO ticketDTO) {
        ticketService.save(ticketDTO);
        return "redirect: /adminpanel/ticket";
    }

    /**
     * Method to delete record from "ticket" table.
     *
     * @param id is id.
     * @return redirects to main page of "ticket" crud.
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") final Long id,
                         @RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                         @RequestParam(value = "pageSize", defaultValue = "15") Integer pageSize,
                         @RequestParam(value = "desc", defaultValue = "false") Boolean desc,
                         @RequestParam(value = "sort", defaultValue = "datetime") String sort, Model model) {
        model.addAttribute("DTOList", ticketService.getPage(pageNo - 1, pageSize, desc, sort));
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("desc", desc);
        model.addAttribute("sort", sort);
        model.addAttribute("pageCount", ticketService.getPageCount(pageSize));
        model.addAttribute("elementsCount", ticketService.getTotalCount());
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        ticketService.deleteTicket(id);
        return "/adminpanel/ticket/crud";
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable("id") final Long id, Model model) {
        model.addAttribute("ticketDTO", ticketService.findTicketById(id));
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return "/adminpanel/ticket/details/details";
    }
}