package com.samsolutions.controller;

import com.samsolutions.dto.UserDTO;
import com.samsolutions.service.RoleService;
import com.samsolutions.service.SecurityService;
import com.samsolutions.service.UserService;
import com.samsolutions.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller of operations for login and registration for user.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.controller
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    /**
     * The method of returning to the client's page the registration form and the list of roles.
     *
     * @param model is model.
     * @return return registration page.
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(final Model model) {
        model.addAttribute("userForm", new UserDTO());
        model.addAttribute("roleList", roleService.findAll());
        return "registration";
    }

    /**
     * The method of checking client's data and registering a new user.
     *
     * @param userForm      is form to create a user.
     * @param bindingResult is checks the object for errors and returns them.
     * @param model         is model.
     * @return if successful, redirects to the welcome page, otherwise returns the registration page.
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") final UserDTO userForm,
                               final BindingResult bindingResult, final Model model) {
        model.addAttribute("ROLE_PATIENT", roleService.findRoleByName("ROLE_PATIENT"));
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());
        return "redirect:/welcome";
    }

    /**
     * The method of checking client's data and login a user.
     *
     * @param model  is model.
     * @param error  contains a string with error
     * @param logout contains a string with success message
     * @return return login page.
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(final Model model, final String error, final String logout) {
        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }

        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }

        return "login";
    }

    /**
     * Welcome page method.
     *
     * @return return welcome page.
     */
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }
}