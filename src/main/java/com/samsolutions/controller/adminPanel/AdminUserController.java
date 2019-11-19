package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.data.UserDataDTO;
import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.service.*;
import com.samsolutions.validator.user.UserCreateValidator;
import com.samsolutions.validator.user.UserPasswordValidator;
import com.samsolutions.validator.user.UserProfileValidator;
import com.samsolutions.validator.user.UserRolesValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
@Secured("ROLE_ADMIN")
public class AdminUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private HealthService healthService;

    @Autowired
    ScheduleService scheduleService;

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
        return "adminpanel/user/details/create";
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
            return "adminpanel/user/details/create";
        }
        userService.save(userFormDTO);
        scheduleService.fillMonth(userFormDTO);
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
        return "adminpanel/user/details/edit";
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
            return "adminpanel/user/details/edit";
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
            return "adminpanel/user/details/edit";
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
            return "adminpanel/user/details/edit";
        }
        userService.updateRoles(userFormDTO);
        return "redirect:/adminpanel/user/details/" + userFormDTO.getId();
    }

    @RequestMapping(value = "edit/profile", method = RequestMethod.POST)
    public String updateProfile(@ModelAttribute("userFormDTO") final UserFormDTO userFormDTO,
                                final BindingResult bindingResult, Model model) {
        userProfileValidator.validate(userFormDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDataDTO", userService.findWithRolesById(userFormDTO.getId()));
            model.addAttribute("roleDTOList", roleService.findAll());
            model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
            model.addAttribute("currentDate", new Date());
            return "adminpanel/user/details/edit";
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


    @RequestMapping(value = "/details/{id}/health", method = RequestMethod.GET)
    public String detailsHealth(@PathVariable(value = "id") final Long id, Model model) {
        model.addAttribute("healthDataDTO", healthService.findByPatientId(id));
        model.addAttribute("userDataDTO", userService.findById(id));
        return "adminpanel/user/details/health/details";
    }
}