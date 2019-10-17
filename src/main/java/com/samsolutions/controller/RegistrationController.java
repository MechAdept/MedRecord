package com.samsolutions.controller;

import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.service.RoleService;
import com.samsolutions.service.SecurityService;
import com.samsolutions.service.UserService;
import com.samsolutions.validator.user.UserCreateValidator;
import com.samsolutions.validator.user.UserRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    private SecurityService securityService;

    @Autowired
    private UserRegistrationValidator userRegistrationValidator;

    @Autowired
    private RoleService roleService;

    /**
     * The method of returning to the client's page the registration form and the list of roles.
     *
     * @param model is model.
     * @return return registration page.
     */
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(final Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            return ("redirect:/welcome");
        }
        model.addAttribute("userFormDTO", new UserFormDTO());
        model.addAttribute("roleList", roleService.findAll());
        return "registration";
    }

    /**
     * The method of checking client's data and registering a new user.
     *
     * @param userFormDTO      is form to create a user.
     * @param bindingResult is checks the object for errors and returns them.
     * @return if successful, redirects to the welcome page, otherwise returns the registration page.
     */
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute final UserFormDTO userFormDTO,
                               final BindingResult bindingResult, Model model) {
        userRegistrationValidator.validate(userFormDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userFormDTO", userFormDTO);
            model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
            model.addAttribute("currentDate", new Date());
            return "registration";
        }
        userService.registration(userFormDTO);
        securityService.autologin(userFormDTO.getUsername(), userFormDTO.getPasswordConfirm());
        return "redirect:/welcome";
    }

    /**
     * The method of checking client's data and login a user.
     *
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
    @Secured("IS_AUTHENTICATED_FULLY")
    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome() {
        return "welcome";
    }
}