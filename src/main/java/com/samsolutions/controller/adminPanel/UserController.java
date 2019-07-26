package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.UserDTO;
import com.samsolutions.service.RoleService;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.List;

/**
 * Controller of crud operations for table "user". //todo:and related
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.controller.adminPanel
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    @Qualifier("encoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * Method to create a new user.
     *
     * @param userDTO form to create a user.
     * @return redirects to main page of "user" crud.
     */
    @RequestMapping(value = "/adminpanel/user/create", method = RequestMethod.POST)
    public String create(@ModelAttribute final UserDTO userDTO) {
        userService.save(userDTO);
        return "redirect: /adminpanel/user";
    }

    /**
     * Method to shows records of "user" table.
     *
     * @param model is model.
     * @return return main page of "user" crud.
     */
    @RequestMapping(value = "/adminpanel/user", method = RequestMethod.GET)
    public String read(final Model model) {
        List<UserDTO> userDTOList = userService.getUsers();
        model.addAttribute("userDTO", new UserDTO());
        model.addAttribute("userDTOList", userDTOList);
        return "crud/usercrud";
    }

    /**
     * Method to shows form for update record of user table.
     *
     * @param model is model.
     * @param id    is id.
     * @return return main page of "user" crud.
     */
    @RequestMapping(value = "/adminpanel/user/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") final Long id, final Model model) {
        UserDTO userDTO = userService.findUserById(id);
        model.addAttribute("userDTOForm", new UserDTO());
        model.addAttribute("userDTO", userDTO);
        model.addAttribute("roleDTOSet", new HashSet<>(roleService.getRoles()));
        return "crud/update/userupdate";
    }

    /**
     * Method for update record of "user" table.
     *
     * @param userDTO form to update a user.
     * @return redirects to main page of "user" crud.
     */
    @RequestMapping(value = "/adminpanel/user/update", method = RequestMethod.POST)
    public String update(@ModelAttribute final UserDTO userDTO) {
        userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userService.update(userDTO);
        return "redirect: /adminpanel/user";
    }

    /**
     * Method to delete record from "user" table.
     *
     * @param id is id.
     * @return redirects to main page of "user" crud.
     */
    @RequestMapping(value = "/adminpanel/user/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") final Long id) {
        userService.delete(id);
        return "redirect: /adminpanel/user";
    }


    /**
     * Returns userService.
     *
     * @return userService.
     */
    public UserService getUserService() {
        return userService;
    }


    /**
     * Returns roleService.
     *
     * @return userService.
     */
    public RoleService getRoleService() {
        return roleService;
    }


    /**
     * Sets userService.
     *
     * @param userService service to be set.
     */
    public void setUserService(final UserService userService) {
        this.userService = userService;
    }

    /**
     * Sets userService.
     *
     * @param roleService service to be set.
     */
    public void setRoleService(final RoleService roleService) {
        this.roleService = roleService;
    }
}