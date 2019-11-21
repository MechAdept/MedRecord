package com.samsolutions.controller.receptionistPanel;

import com.samsolutions.dto.data.UserDataDTO;
import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.service.RoleService;
import com.samsolutions.service.ScheduleService;
import com.samsolutions.service.UserService;
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

@Controller
@Secured("ROLE_RECEPTIONIST")
@RequestMapping("/receptionistpanel/user")
public class ReceptionistUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserCreateValidator userCreateValidator;

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private UserProfileValidator userProfileValidator;

    @Autowired
    private UserPasswordValidator userPasswordValidator;

    @Autowired
    private UserRolesValidator userRolesValidator;

    @RequestMapping(method = RequestMethod.GET)
    public String roleChoose() {
        return "/receptionistpanel/roleChoose";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/profile")
    public String profile(Model model) {
        model.addAttribute("userDataDTO", userService.getCurrent());
        model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
        return "/receptionistpanel/user/profile";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public String details(@PathVariable("userId") final Long userId, Model model) {
        UserDataDTO currentUser = userService.getCurrent();
        UserDataDTO userDataDTO = userService.findWithRolesById(userId);
        if (userDataDTO.equals(currentUser)) {
            return "redirect:/receptionistpanel/user/profile";
        }
        model.addAttribute("userDataDTO", userDataDTO);
        model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
        return "receptionistpanel/user/details";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        model.addAttribute("userFormDTO", new UserFormDTO());
        model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
        model.addAttribute("roleDTOList", roleService.findAllWithoutAdmin());
        model.addAttribute("currentDate", new Date());
        return "/receptionistpanel/user/create";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String create(@ModelAttribute("userFormDTO") final UserFormDTO userFormDTO, Model model, BindingResult bindingResult) {
        userCreateValidator.validate(userFormDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("roleDTOList", roleService.findAllWithoutAdmin());
            model.addAttribute("currentDate", new Date());
            model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
            return "receptionistpanel/user/create";
        }
        userService.save(userFormDTO);
        scheduleService.fillMonth(userFormDTO);
        return "/receptionistpanel/roleChoose";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}/delete")
    public String delete(@PathVariable("userId") final Long userId) {
        userService.delete(userId);
        return "redirect:/receptionistpanel/user";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}/update")
    public String update(@PathVariable("userId") final Long userId, Model model) {
        model.addAttribute("userDataDTO", userService.findWithRolesById(userId));
        model.addAttribute("userFormDTO", new UserFormDTO());
        model.addAttribute("roleDTOList", roleService.findAllWithoutAdmin());
        model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
        model.addAttribute("currentDate", new Date());
        return "/receptionistpanel/user/update";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("userFormDTO") final UserFormDTO userFormDTO,
                         final BindingResult bindingResult, final Model model) {
        userProfileValidator.validate(userFormDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDataDTO", userService.findWithRolesById(userFormDTO.getId()));
            model.addAttribute("roleDTOList", roleService.findAllWithoutAdmin());
            model.addAttribute("currentDate", new Date());
            model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
            return "receptionistpanel/user/update";
        }
        return "redirect:/receptionistpanel/user/" + userFormDTO.getId() + "/update";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update/photo")
    public String updatePhoto(@RequestParam("id") String id, @RequestParam("file") MultipartFile file) throws IOException {
        userService.updatePhoto(Long.parseLong(id), file);
        return "redirect:/receptionistpanel/user/" + id;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update/pass")
    public String updatePassword(@ModelAttribute("userFormDTO") final UserFormDTO userFormDTO,
                                 final BindingResult bindingResult, Model model) {
        userPasswordValidator.validate(userFormDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
            model.addAttribute("currentDate", new Date());
            model.addAttribute("roleDTOList", roleService.findAllWithoutAdmin());
            model.addAttribute("userDataDTO", userService.findWithRolesById(userFormDTO.getId()));
            return "receptionistpanel/user/update";
        }
        userService.updatePassword(userFormDTO);
        return "redirect:/receptionistpanel/user/" + userFormDTO.getId();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update/roles")
    public String updateRoles(@ModelAttribute("userFormDTO") final UserFormDTO userFormDTO,
                              final BindingResult bindingResult, Model model) {
        userRolesValidator.validate(userFormDTO, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("userDataDTO", userService.findWithRolesById(userFormDTO.getId()));
            model.addAttribute("roleDTOList", roleService.findAllWithoutAdmin());
            model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
            model.addAttribute("currentDate", new Date());
            return "receptionistpanel/user/update";
        }
        userService.updateRoles(userFormDTO);
        return "redirect:/receptionistpanel/user/" + userFormDTO.getId();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/patients")
    public String patients(Model model,
                           @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                           @RequestParam(value = "desc", required = false, defaultValue = "false") Boolean desc,
                           @RequestParam(value = "sort", required = false, defaultValue = "id") String sort) {
        model.mergeAttributes(userService.getMapAndPageWithPatientsForReceptionist(pageNo, pageSize, desc, sort));
        return "/receptionistpanel/user/crud";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/doctors")
    public String doctors(Model model,
                          @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                          @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                          @RequestParam(value = "desc", required = false, defaultValue = "false") Boolean desc,
                          @RequestParam(value = "sort", required = false, defaultValue = "id") String sort) {
        model.mergeAttributes(userService.getMapAndPageWithDoctorsForReceptionist(pageNo, pageSize, desc, sort));
        return "/receptionistpanel/user/crud";
    }

}
