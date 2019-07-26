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

import java.util.List;

/**
 * Controller of crud operations for table "role".
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.controller.adminPanel
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     * Method to create a new role.
     *
     * @param roleDTO form to create a role.
     * @return redirects to main page of "role" crud.
     */
    @RequestMapping(value = "/adminpanel/role/create", method = RequestMethod.POST)
    public String create(@ModelAttribute(name = "roleDTO") final RoleDTO roleDTO) {
        roleService.save(roleDTO);
        return "redirect: /adminpanel/role";
    }

    /**
     * Method to shows records of "role" table.
     *
     * @param model is model.
     * @return return main page of "role" crud.
     */
    @RequestMapping(value = "/adminpanel/role", method = RequestMethod.GET)
    public String read(final Model model) {
        List<RoleDTO> roleDTOList = roleService.getRoles();
        model.addAttribute("roleDTOForm", new RoleDTO());
        model.addAttribute("roleDTOList", roleDTOList);
        return "crud/rolecrud";
    }

    /**
     * Method to shows form for update record of role table.
     *
     * @param model is model.
     * @param id    is id.
     * @return return main page of "role" crud.
     */
    @RequestMapping(value = "/adminpanel/role/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") final Long id, final Model model) {
        RoleDTO roleDTO = roleService.findRoleById(id);
        model.addAttribute("roleDTO", roleDTO);
        model.addAttribute("roleDTOForm", new RoleDTO());
        return "crud/update/roleupdate";
    }

    /**
     * Method for update record of "role" table.
     *
     * @param roleDTO form to update a role.
     * @return redirects to main page of "role" crud.
     */
    @RequestMapping(value = "adminpanel/role/update", method = RequestMethod.POST)
    public String update(@ModelAttribute final RoleDTO roleDTO) {
        roleService.update(roleDTO);
        return "redirect: /adminpanel/role";
    }

    /**
     * Method to delete record from "role" table.
     *
     * @param id is id.
     * @return redirects to main page of "role" crud.
     */
    @RequestMapping(value = "/adminpanel/role/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") final Long id) {
        roleService.deleteRole(id);
        return "redirect: /adminpanel/role";
    }
}
