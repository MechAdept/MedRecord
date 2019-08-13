package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.UserDTO;
import com.samsolutions.service.RoleService;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;

/**
 * Controller of crud operations for table "user". //todo:and related
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.controller.adminPanel
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Controller
@RequestMapping("/adminpanel/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * Method to create a new user.
     *
     * @return redirects to main page of "user" crud.
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@RequestParam(value = "password") String password, @RequestParam(value = "username")
            String username, @RequestParam(value = "roles") Long[] roles) {
        UserDTO userDTO = new UserDTO(username, password, roleService.findRolesById(roles));
        userService.save(userDTO);
        return "redirect: /adminpanel/user";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@ModelAttribute final UserDTO userDTO, Model model) {
        model.addAttribute("userDTOForm", new UserDTO());
        model.addAttribute("roleDTOList", roleService.findAll());
        return "adminpanel/user/usercreate";
    }

    /**
     * Method to shows records of "user" table.
     *
     * @param model is model.
     * @return return main page of "user" crud.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String read(final Model model, @RequestParam(value = "pageNo",
            required = false, defaultValue = "1") Integer pageNo,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                       @RequestParam(value = "idSort", required = false, defaultValue = "false")
                               Boolean idSortReverse) {
        model.addAttribute("DTOList", userService.getPage(pageNo - 1, pageSize, idSortReverse));
        model.addAttribute("pageNo", pageNo);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("idSort", idSortReverse);
        model.addAttribute("pageCount", userService.getPageCount(pageSize));
        model.addAttribute("elementsCount", userService.getTotalCount());
        return "adminpanel/user/usercrud";
    }

    /**
     * Method to shows form for edit record of user table.
     *
     * @param model is model.
     * @param id    is id.
     * @return return main page of "user" crud.
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") final Long id, final Model model) {
        UserDTO userDTO = userService.findUserById(id);
        model.addAttribute("userDTOForm", new UserDTO());
        model.addAttribute("userDTO", userDTO);
        model.addAttribute("roleDTOList", new HashSet<>(roleService.findAll()));
        return "adminpanel/user/useredit";
    }

    /**
     * Method for edit record of "user" table.
     *
     * @return redirects to main page of "user" crud.
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam(value = "id", required = true) Long id,
                       @RequestParam(value = "password", required = false) String password,
                       @RequestParam(value = "username", required = false) String username,
                       @RequestParam(value = "roles", required = false) Long[] roles) {
        UserDTO userDTO = userService.findUserById(id);
        userDTO.setUsername(username);
        userDTO.setPassword(password);
        userDTO.setRoles(roleService.findRolesById(roles));
        userService.save(userDTO);
        return "redirect: /adminpanel/user";
    }

    /**
     * Method to delete record from "user" table.
     *
     * @param id is id.
     * @return redirects to main page of "user" crud.
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") final Long id) {
        userService.delete(id);
        return "redirect: /adminpanel/user";
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String details(@PathVariable("id") final Long id, Model model) {
        UserDTO userDTO = userService.findUserById(id);
        model.addAttribute("userDTO", userDTO);
        return "/adminpanel/user/details/userdetails";
    }

    @RequestMapping(value = "/details/{id}/roles", method = RequestMethod.GET)
    public String detailsRole(@PathVariable(value = "id") final Long id, Model model) {
        model.addAttribute("roleDTOSet", roleService.getRolesByUser(userService.findUserById(id)));
        model.addAttribute("userDTO", userService.findUserById(id));
        return "/adminpanel/user/details/userroles";
    }

    @RequestMapping(value = "/details/{id}/roles/delete/{roleId}", method = RequestMethod.GET)
    public String detailsRoleDelete(@PathVariable(value = "id") final Long id,
                                    @PathVariable(value = "roleId") final Long roleId) {
        userService.deleteRoleFromUserById(id, roleId);
        return "redirect: /adminpanel/user/details/" + id + "/roles/";
    }
}