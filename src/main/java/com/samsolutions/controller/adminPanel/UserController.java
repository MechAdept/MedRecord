package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.data.UserDataDTO;
import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.service.HealthService;
import com.samsolutions.service.RoleService;
import com.samsolutions.service.TicketService;
import com.samsolutions.service.UserService;
import com.samsolutions.validator.user.UserCreateValidator;
import com.samsolutions.validator.user.UserPasswordValidator;
import com.samsolutions.validator.user.UserRolesValidator;
import com.samsolutions.validator.user.UserProfileValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private HealthService healthService;

    @Autowired
    UserCreateValidator userCreateValidator;

    @Autowired
    UserProfileValidator userProfileValidator;

    @Autowired
    UserPasswordValidator userPasswordValidator;

    @Autowired
    UserRolesValidator userRolesValidator;

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@ModelAttribute final UserFormDTO userFormDTO, Model model) {
        model.addAttribute("userFormDTO", new UserFormDTO());
        model.addAttribute("roleDTOList", roleService.findAll());
        model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
        model.addAttribute("currentDate", new Date());
        return "adminpanel/user/create";
    }

    /**
     * Method to create a new user.
     *
     * @return redirects to main page of "user" crud.
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@ModelAttribute("userFormDTO") final UserFormDTO userFormDTO,
                         final BindingResult bindingResult, final Model model) {
        userCreateValidator.validate(userFormDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("roleDTOList", roleService.findAll());
            model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
            model.addAttribute("currentDate", new Date());
            return "adminpanel/user/create";
        }
        userService.create(userFormDTO);
        return "redirect:/adminpanel/user";
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
        model.addAttribute("userFormDTO", new UserFormDTO());
        model.addAttribute("userDataDTO", userService.findWithRolesById(id));
        model.addAttribute("roleDTOList", new HashSet<>(roleService.findAll()));
        model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
        model.addAttribute("currentDate", new Date());
        return "adminpanel/user/edit";
    }

    /**
     * Method for edit record of "user" table.
     *
     * @return redirects to main page of "user" crud.
     */
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String edit(@ModelAttribute("userFormDTO") final UserFormDTO userFormDTO,
                       final BindingResult bindingResult, final Model model) {
        userProfileValidator.validate(userFormDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDataDTO", userService.findWithRolesById(userFormDTO.getId()));
            model.addAttribute("roleDTOList", roleService.findAll());
            model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
            model.addAttribute("currentDate", new Date());
            return "adminpanel/user/edit";
        }
        return "redirect:/adminpanel/user/details" + userFormDTO.getId();
    }

    @RequestMapping(value = "/edit/photo", method = RequestMethod.POST)
    public String updatePhoto(@RequestParam("id") String id, @RequestParam("file") MultipartFile file) throws IOException {
        userService.updatePhoto(Long.parseLong(id), file);
        return "redirect:/adminpanel/user/details/" + id;
    }

    @RequestMapping(value = "/edit/pass", method = RequestMethod.POST)
    public String updatePassword(@ModelAttribute("userFormDTO") final UserFormDTO userFormDTO,
                                 final BindingResult bindingResult, Model model) {
        userPasswordValidator.validate(userFormDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDataDTO", userService.findWithRolesById(userFormDTO.getId()));
            model.addAttribute("roleDTOList", roleService.findAll());
            model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
            model.addAttribute("currentDate", new Date());
            return "adminpanel/user/edit";
        }
        userService.updatePassword(userFormDTO);
        return "redirect:/adminpanel/user/details/" + userFormDTO.getId();
    }

    @RequestMapping(value = "/edit/roles", method = RequestMethod.POST)
    public String updateRoles(@ModelAttribute("userFormDTO") final UserFormDTO userFormDTO,
                              final BindingResult bindingResult, Model model) {
        userRolesValidator.validate(userFormDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDataDTO", userService.findWithRolesById(userFormDTO.getId()));
            model.addAttribute("roleDTOList", roleService.findAll());
            model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
            model.addAttribute("currentDate", new Date());
            return "adminpanel/user/edit";
        }
        userService.updateRoles(userFormDTO);
        return "redirect:/adminpanel/user/details/" + userFormDTO.getId();
    }

    @RequestMapping(value = "edit/profile",method = RequestMethod.POST)
    public String updateProfile(@ModelAttribute("userFormDTO") final UserFormDTO userFormDTO,
                                final BindingResult bindingResult, Model model) {
        userProfileValidator.validate(userFormDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDataDTO", userService.findWithRolesById(userFormDTO.getId()));
            model.addAttribute("roleDTOList", roleService.findAll());
            model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
            model.addAttribute("currentDate", new Date());
            return "adminpanel/user/edit";
        }
        userService.updateProfile(userFormDTO);
        return "redirect:/adminpanel/user/details/" + userFormDTO.getId();
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
        UserDataDTO userDataDTO = userService.findWithRolesById(id);
        model.addAttribute("userDataDTO", userDataDTO);
        model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
        return "adminpanel/user/details/details";
    }

    @RequestMapping(value = "/details/{id}/roles", method = RequestMethod.GET)
    public String detailsRole(@PathVariable(value = "id") final Long id, Model model) {
        model.addAttribute("userDTO", userService.findWithRolesById(id));
        return "/adminpanel/user/details/roles";
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
        model.addAttribute("healthDTO", healthService.findByPatientId(id));
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
        ticketService.delete(ticketId);
        model.mergeAttributes(ticketService.getMapAndPageByUser(id, pageNo, pageSize, desc, sort));
        model.addAttribute("formatter", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        return "/adminpanel/user/details/tickets";
    }
}