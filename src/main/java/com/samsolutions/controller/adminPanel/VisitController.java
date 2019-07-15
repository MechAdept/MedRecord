package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.VisitDTO;
import com.samsolutions.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class VisitController {
    @Autowired
    private VisitService visitService;

    @RequestMapping(value = "/adminpanel/visit/create", method = RequestMethod.POST)
    public String visitCrud(@ModelAttribute(name = "visitDTO") VisitDTO visitDTO, Model model) {
        visitService.save(visitDTO);
        return "redirect: /adminpanel/visit";
    }

    @RequestMapping(value = "/adminpanel/visit", method = RequestMethod.GET)
    public String visitCrud(Model model) {
        List<VisitDTO> visitDTOList = visitService.getvisits();
        model.addAttribute("visitDTOForm", new VisitDTO());
        model.addAttribute("visitDTOList", visitDTOList);
        return "crud/visitcrud";
    }

    @RequestMapping(value = "/adminpanel/visit/update/{id}", method = RequestMethod.GET)
    public String visitUpdate(@PathVariable("id") Long id, Model model) {
        VisitDTO visitDTO = visitService.findVisitById(id);
        model.addAttribute("visitDTO", visitDTO);
        model.addAttribute("visitDTOForm", new VisitDTO());
        return "crud/update/visitupdate";
    }

    @RequestMapping(value = "adminpanel/visit/update", method = RequestMethod.POST)
    public String visitUpdate(@ModelAttribute VisitDTO visitDTO, Model model) {
        visitService.update(visitDTO);
        return "redirect: /adminpanel/visit";
    }

    @RequestMapping(value = "/adminpanel/visit/delete/{id}", method = RequestMethod.GET)
    public String visitCrud(@PathVariable("id") Long id, Model model) {
        visitService.deleteVisit(id);
        return "redirect: /adminpanel/visit";
    }
}

