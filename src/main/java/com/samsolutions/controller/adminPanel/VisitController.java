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

/**
 * Controller of crud operations for table "visit".
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.controller.adminPanel
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Controller
public class VisitController {
    @Autowired
    private VisitService visitService;

    /**
     * Method to create a new visit.
     *
     * @param visitDTO form to create a visit.
     * @return redirects to main page of "visit" crud.
     */
    @RequestMapping(value = "/adminpanel/visit/create", method = RequestMethod.POST)
    public String create(@ModelAttribute(name = "visitDTO") final VisitDTO visitDTO) {
        visitService.save(visitDTO);
        return "redirect: /adminpanel/visit";
    }

    /**
     * Method to shows records of "visit" table.
     *
     * @param model is model.
     * @return return main page of "visit" crud.
     */
    @RequestMapping(value = "/adminpanel/visit", method = RequestMethod.GET)
    public String read(final Model model) {
        List<VisitDTO> visitDTOList = visitService.getVisits();
        model.addAttribute("visitDTOForm", new VisitDTO());
        model.addAttribute("visitDTOList", visitDTOList);
        return "crud/visitcrud";
    }

    /**
     * Method to shows form for update record of visit table.
     *
     * @param model is model.
     * @param id    is id.
     * @return return main page of "visit" crud.
     */
    @RequestMapping(value = "/adminpanel/visit/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") final Long id, final Model model) {
        VisitDTO visitDTO = visitService.findVisitById(id);
        model.addAttribute("visitDTO", visitDTO);
        model.addAttribute("visitDTOForm", new VisitDTO());
        return "crud/update/visitupdate";
    }

    /**
     * Method for update record of "visit" table.
     *
     * @param visitDTO form to update a visit.
     * @return redirects to main page of "visit" crud.
     */
    @RequestMapping(value = "adminpanel/visit/update", method = RequestMethod.POST)
    public String update(@ModelAttribute final VisitDTO visitDTO) {
        visitService.save(visitDTO);
        return "redirect: /adminpanel/visit";
    }

    /**
     * Method to delete record from "visit" table.
     *
     * @param id is id.
     * @return redirects to main page of "visit" crud.
     */
    @RequestMapping(value = "/adminpanel/visit/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") final Long id) {
        visitService.deleteVisit(id);
        return "redirect: /adminpanel/visit";
    }
}

