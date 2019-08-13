package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.HealthDTO;
import com.samsolutions.service.HealthService;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller of crud operations for table "health".
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.controller.adminPanel
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Controller
@RequestMapping(value = "/adminpanel/health")
public class HealthController {
    @Autowired
    private HealthService healthService;

    @Autowired
    private UserService userService;

    /**
     * Method to create a new health card.
     *
     * @return redirects to main page of "health" crud.
     */
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@RequestParam("patient") Long patientID,
                         @RequestParam(value = "birth") String birth,
                         @RequestParam(value = "photo") String photo) {
        HealthDTO healthDTO = new HealthDTO();
        healthDTO.setPatient(userService.findUserById(patientID));
        healthDTO.setBirth(birth);
        healthDTO.setPhoto(photo);
        healthService.save(healthDTO);
        return "redirect: /adminpanel/health";
    } //Todo: Add patient check


    /**
     * Method to shows records of "health" table.
     *
     * @param model is model.
     * @return return main page of "health" crud.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String read(final Model model, @RequestParam(value = "pageNo",
            required = false, defaultValue = "1") Integer pageNo,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                       @RequestParam(value = "idSort", required = false, defaultValue = "false")
                               Boolean idSortReverse) {
        model.addAttribute("DTOList", healthService.getPage(pageNo - 1, pageSize, idSortReverse));
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("idSort", idSortReverse);
        model.addAttribute("pageCount", healthService.getPageCount(pageSize));
        model.addAttribute("elementsCount", healthService.getTotalCount());
        return "adminpanel/health/healthcrud";
    }

    /**
     * Method to shows form for update record of health table.
     *
     * @param model is model.
     * @param id    is id.
     * @return return main page of "health" crud.
     */
    @RequestMapping(value = "/adminpanel/health/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") final Long id, final Model model) {
        HealthDTO healthDTO = healthService.findHealthById(id);
        model.addAttribute("healthDTO", healthDTO);
        model.addAttribute("healthDTOForm", new HealthDTO());
        return "adminpanel/health/healthupdate";
    }

    /**
     * Method for edit record of "health" table.
     *
     * @param healthDTO form to update a health card.
     * @return redirects to main page of "health" crud.
     */
    @RequestMapping(value = "adminpanel/health/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute final HealthDTO healthDTO) {
        healthService.save(healthDTO);
        return "redirect: /adminpanel/health";
    }

    /**
     * Method to delete record from "health" table.
     *
     * @param id is id.
     * @return redirects to main page of "health" crud.
     */
    @RequestMapping(value = "/adminpanel/health/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") final Long id) {
        healthService.deleteHealth(id);
        return "redirect: /adminpanel/health";
    }
}
