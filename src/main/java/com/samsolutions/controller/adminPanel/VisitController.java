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
import org.springframework.web.bind.annotation.RequestParam;

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
public class VisitController {
    @Autowired
    private VisitService visitService;

    /**
     * Method to create a new visit.
     *
     * @param visitDTO form to create a visit.
     * @return redirects to main page of "visit" crud.
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute(name = "visitDTO") final VisitDTO visitDTO) {
        visitService.save(visitDTO);
        return "redirect: /adminpanel/visit";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String read(final Model model, @RequestParam(value = "pageNo",
            required = false, defaultValue = "1") Integer pageNo,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                       @RequestParam(value = "idSort", required = false, defaultValue = "false")
                               Boolean idSortReverse) {
        model.addAttribute("DTOList", visitService.getPage(pageNo - 1, pageSize, idSortReverse));
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("idSort", idSortReverse);
        model.addAttribute("pageCount", visitService.getPageCount(pageSize));
        model.addAttribute("elementsCount", visitService.getTotalCount());
        return "adminpanel/visit/visitcrud";
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
        VisitDTO visitDTO = visitService.findVisitById(id);
        model.addAttribute("visitDTO", visitDTO);
        model.addAttribute("visitDTOForm", new VisitDTO());
        return "adminpanel/visit/visitedit";
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
        visitService.deleteVisit(id);
        return "redirect: /adminpanel/visit";
    }
}

