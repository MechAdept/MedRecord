package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.data.UserDTO;
import com.samsolutions.service.HealthService;
import com.samsolutions.service.RoleService;
import com.samsolutions.service.TicketService;
import com.samsolutions.service.UserService;
import com.samsolutions.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.format.DateTimeFormatter;
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
@PreAuthorize("isAuthenticated()")
public class UserController {

    @Autowired
    UserValidator userValidator;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private HealthService healthService;

    /**
     * Method to create a new user.
     *
     * @return redirects to main page of "user" crud.
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("userDTOForm") final UserDTO userDTOForm,
                         final BindingResult bindingResult, final Model model) {
        userValidator.validate(userDTOForm, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("roleDTOList", roleService.findAll());
            return "adminpanel/user/create";
        }
        userService.save(userDTOForm);
        return "redirect:/adminpanel/user";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@ModelAttribute final UserDTO userDTO, Model model) {
        model.addAttribute("userDTOForm", new UserDTO());
        model.addAttribute("roleDTOList", roleService.findAll());
        return "adminpanel/user/create";
    }

    /**
     * Method to shows records of "user" table.
     *
     * @param model is model.
     * @return return main page of "user" crud.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String read(final Model model,
                       @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                       @RequestParam(value = "desc", required = false, defaultValue = "false") Boolean desc,
                       @RequestParam(value = "sort", required = false, defaultValue = "id") String sort) {
        model.mergeAttributes(userService.getMapAndPage(pageNo, pageSize, desc, sort));
        return "adminpanel/user/crud";
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
        UserDTO userDTO = userService.findById(id);
        model.addAttribute("userDTOForm", new UserDTO());
        model.addAttribute("userDTO", userDTO);
        model.addAttribute("roleDTOList", new HashSet<>(roleService.findAll()));
        return "adminpanel/user/edit";
    }

    /**
     * Method for edit record of "user" table.
     *
     * @return redirects to main page of "user" crud.
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@RequestParam(value = "id") Long id,
                       @RequestParam(value = "password", required = false) String password,
                       @RequestParam(value = "username", required = false) String username,
                       @RequestParam(value = "roles", required = false) Long[] roles) {
        UserDTO userDTO = userService.findById(id);
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
        UserDTO userDTO = userService.findWithRolesById(id);
        model.addAttribute("userDTO", userDTO);
        return "/adminpanel/user/details/details";
    }

    @RequestMapping(value = "/details/{id}/roles", method = RequestMethod.GET)
    public String detailsRole(@PathVariable(value = "id") final Long id, Model model) {
        model.addAttribute("userDTO", userService.findWithRolesById(id));
        return "/adminpanel/user/details/roles";
    }

    @RequestMapping(value = "/details/{id}/roles/delete/{roleid}", method = RequestMethod.GET)
    public String detailsRoleDelete(@PathVariable(value = "id") final Long id,
                                    @PathVariable(value = "roleid") final Long roleId, Model model) {
        userService.deleteRoleFromUserById(id, roleId);
        model.addAttribute("userDTO", userService.findWithRolesById(id));
        return "adminpanel/user/details/roles";
    }

    @RequestMapping(value = "/details/{id}/tickets", method = RequestMethod.GET)
    public String detailsTickets(final Model model, @PathVariable(value = "id") Long id,
                                 @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                                 @RequestParam(value = "desc", required = false, defaultValue = "true") Boolean desc,
                                 @RequestParam(value = "sort", required = false, defaultValue = "datetime") String sort) {
        model.mergeAttributes(ticketService.getMapAndPageByUser(id, pageNo, pageSize, desc, sort));
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        model.addAttribute("userDTO", userService.findById(id));
        return "/adminpanel/user/details/tickets";
    }

    @RequestMapping(value = "/details/{id}/health", method = RequestMethod.GET)
    public String detailsHealth(@PathVariable(value = "id") final Long id, Model model) {
        model.addAttribute("healthDTO", healthService.findHealthByPatientId(id));
        model.addAttribute("userDTO", userService.findById(id));
        return "adminpanel/health/details";
    }

    @RequestMapping(value = "/details/{id}/tickets/delete/{ticketId}", method = RequestMethod.GET)
    public String detailsTicketsDelete(final Model model, @PathVariable(value = "id") Long id,
                                       @PathVariable(value = "ticketId") Long ticketId,
                                       @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                       @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                                       @RequestParam(value = "desc", required = false, defaultValue = "true") Boolean desc,
                                       @RequestParam(value = "sort", required = false, defaultValue = "datetime") String sort) {
        ticketService.deleteTicket(ticketId);
        model.mergeAttributes(ticketService.getMapAndPageByUser(id, pageNo, pageSize, desc, sort));
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return "/adminpanel/user/details/tickets";
    }
}