package com.samsolutions.controller.adminPanel;

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
@Secured("ROLE_ADMIN")
public class VisitController {
    @Autowired
    private VisitService visitService;

    @Autowired
    private TicketService ticketService;

    @RequestMapping(value = "/create/{ticketId}", method = RequestMethod.GET)
    public String create(@PathVariable(value = "ticketId") final Long ticketId, Model model) {
        model.addAttribute("ticketDataDTO", ticketService.findById(ticketId));
        VisitFormDTO visitFormDTO = new VisitFormDTO();
        visitFormDTO.setDatetime(LocalDateTime.now().toString());
        model.addAttribute("visitFormDTO", visitFormDTO);
        return "/adminpanel/user/details/ticket/visit/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String save(@ModelAttribute("visitFormDTO") final VisitFormDTO visitFormDTO, Model model) {
        visitService.save(visitFormDTO);
        model.addAttribute("visitDataDTO", visitService.findByTicketId(visitFormDTO.getTicketId()));
        model.addAttribute("ticketDataDTO",ticketService.findById(visitFormDTO.getTicketId()));
        return "/adminpanel/user/details/ticket/visit/details";
    }

    @RequestMapping(value = "/{ticketId}", method = RequestMethod.GET)
    public String details(@PathVariable(value = "ticketId") final Long ticketId, Model model) {
        VisitDataDTO visitDataDTO = visitService.findByTicketId(ticketId);
        if (visitDataDTO.getId() != null) {
            model.addAttribute("visitDataDTO", visitDataDTO);
            model.addAttribute("ticketDataDTO",ticketService.findById(ticketId));
            model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            return "/adminpanel/user/details/ticket/visit/details";
        } else {
            return "redirect: /adminpanel/visit/create/" + ticketId;
        }
    }


}

