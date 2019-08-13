package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.RoleDTO;
import com.samsolutions.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Controller of crud operations for table "role".
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.controller.adminPanel
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Controller
@RequestMapping("/adminpanel/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * Method to create a new role.
     *
     * @return redirects to main page of "role" crud.
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(Model model) {
        model.addAttribute("roleDTOForm", new RoleDTO());
        return "adminpanel/role/rolecreate";
    }

    /**
     * Method to shows records of "role" table.
     *
     * @param model is model.
     * @return return main page of "role" crud.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String read(final Model model, @RequestParam(value = "pageNo",
            required = false, defaultValue = "1") Integer pageNo,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                       @RequestParam(value = "idSort", required = false, defaultValue = "false")
                               Boolean idSortReverse) {
        model.addAttribute("DTOList", roleService.getPage(pageNo - 1, pageSize, idSortReverse));
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("idSort", idSortReverse);
        model.addAttribute("pageCount", roleService.getPageCount(pageSize));
        model.addAttribute("elementsCount", roleService.getTotalCount());
        return "adminpanel/role/rolecrud";
    }

    /**
     * Method for edit record of "role" table.
     *
     * @param roleDTO form to edit a role.
     * @return redirects to main page of "role" crud.
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute final RoleDTO roleDTO) {
        roleService.save(roleDTO);
        return "redirect: /adminpanel/role";
    }

    /**
     * Method to shows form for edit record of role table.
     *
     * @param model is model.
     * @param id    is id.
     * @return return main page of "role" crud.
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") final Long id, final Model model) {
        RoleDTO roleDTO = roleService.findRoleById(id);
        model.addAttribute("roleDTO", roleDTO);
        model.addAttribute("roleDTOForm", new RoleDTO());
        return "/adminpanel/role/roleedit";
    }

    /**
     * Method to delete record from "role" table.
     *
     * @param id is id.
     * @return redirects to main page of "role" crud.
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") final Long id) {
        roleService.deleteRole(id);
        return "redirect: /adminpanel/role";
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable("id") final Long id, Model model) {
        RoleDTO roleDTO = roleService.findRoleById(id);
        model.addAttribute("roleDTO", roleDTO);
        return "/adminpanel/role/details/roledetails";
    }
}