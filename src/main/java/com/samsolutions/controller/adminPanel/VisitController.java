package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.TicketDTO;
import com.samsolutions.dto.VisitDTO;
import com.samsolutions.service.TicketService;
import com.samsolutions.service.UserService;
import com.samsolutions.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller of crud operations for table "visit".
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.controller.adminPanel
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Controller
@RequestMapping("/adminpanel/visit")
@PreAuthorize("isAuthenticated()")
public class VisitController {
    @Autowired
    private VisitService visitService;

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/create/{ticketId}", method = RequestMethod.GET)
    public String create(@PathVariable(value = "ticketId") final Long ticketId, Model model) {
        TicketDTO ticketDTO = ticketService.findTicketById(ticketId);
        model.addAttribute("ticketDTO", ticketDTO);
        model.addAttribute("visitDTOForm", new VisitDTO());
        return "/adminpanel/visit/create";
    }

    /**
     * Method to shows form for edit record of visit table.
     *
     * @param model is model.
     * @param id    is id.
     * @return return main page of "visit" crud.
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") final Long id, final Model model) {
        VisitDTO visitDTO = visitService.findById(id);
        model.addAttribute("visitDTO", visitDTO);
        model.addAttribute("visitDTOForm", new VisitDTO());
        return "adminpanel/visit/edit";
    }

    /**
     * Method for edit record of "visit" table.
     *
     * @param visitDTO form to edit a visit.
     * @return redirects to main page of "visit" crud.
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute final VisitDTO visitDTO) {
        visitService.save(visitDTO);
        return "redirect: /adminpanel/visit";
    }

    /**
     * Method to delete record from "visit" table.
     *
     * @param id is id.
     * @return redirects to main page of "visit" crud.
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") final Long id) {
        visitService.delete(id);
        return "redirect: /adminpanel/visit";
    }
}

