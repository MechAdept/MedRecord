package com.samsolutions.controller.medicPanel;

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

@Controller
@Secured("ROLE_MEDIC")
@RequestMapping("/medicpanel/ticket")
public class MedicTicketController {

    @Autowired
    TicketService ticketService;

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/{ticketId}")
    public String details(@PathVariable("ticketId") final Long ticketId, Model model) {
        TicketDataDTO ticketDataDTO = ticketService.findById(ticketId);
        model.addAttribute("ticketDataDTO", ticketDataDTO);
        model.addAttribute("patientDataDTO", ticketDataDTO.getPatient());
        model.addAttribute("doctorDataDTO", ticketDataDTO.getDoctor());
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return "/medicpanel/ticket/details";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String ticketList(Model model, @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                             @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                             @RequestParam(value = "desc", required = false, defaultValue = "false") Boolean desc,
                             @RequestParam(value = "sort", required = false, defaultValue = "id") String sort) {
        model.mergeAttributes(ticketService.getMapAndPageForCurrentUser(pageNo, pageSize, desc, sort));
        model.addAttribute("userDataDTO", userService.getCurrent());
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return "/medicpanel/ticket/list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}/list")
    public String patientTicketList(Model model, @PathVariable("userId") final Long userId,
                                    @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                                    @RequestParam(value = "desc", required = false, defaultValue = "false") Boolean desc,
                                    @RequestParam(value = "sort", required = false, defaultValue = "id") String sort) {
        model.mergeAttributes(ticketService.getMapAndPageByUser(userId, pageNo, pageSize, desc, sort));
        model.addAttribute("userDataDTO", userService.findById(userId));
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return "/medicpanel/ticket/patientList";
    }
}
