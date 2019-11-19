package com.samsolutions.controller.medicPanel;

import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.roles.Roles;
import com.samsolutions.service.UserService;
import com.samsolutions.validator.user.UserPasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.SimpleDateFormat;

@Controller
@Secured("ROLE_MEDIC")
@RequestMapping("/medicpanel/user")
public class MedicUserController {

    @Autowired
    UserService userService;

    @Autowired
    UserPasswordValidator userPasswordValidator;

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public String details(@PathVariable("userId") final Long userId, Model model) {
        model.addAttribute("userDataDTO", userService.findById(userId));
        model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
        return "/medicpanel/user/details";
    }

    @RequestMapping(method = RequestMethod.GET)
    public String profile(Model model) {
        model.addAttribute("userDataDTO", userService.getCurrent());
        model.addAttribute("userFormDTO", new UserFormDTO());
        model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
        return "/medicpanel/user/profile";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updatephoto")
    public String updatePhoto(@RequestParam("file") MultipartFile file) throws IOException {
        userService.updatePhoto(userService.getCurrent().getId(), file);
        return "redirect:/medicpanel/user";
    }


    @RequestMapping(method = RequestMethod.POST, value = "/updatepass")
    public String updatePassword(final Model model, @ModelAttribute("userFormDTO") final UserFormDTO userFormDTO, final BindingResult bindingResult) {
        userPasswordValidator.validate(userFormDTO, bindingResult);
        if ((bindingResult.hasErrors())) {
            model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
            model.addAttribute("userDataDTO", userService.getCurrent());
            return "medicpanel/user/profile";
        }
        userService.updatePassword(userFormDTO);
        return "redirect:/medicpanel/user";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/patients")
    public String patients(Model model, @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                           @RequestParam(value = "pageSize", required = false, defaultValue = "15") Integer pageSize,
                           @RequestParam(value = "desc", required = false, defaultValue = "false") Boolean desc,
                           @RequestParam(value = "sort", required = false, defaultValue = "id") String sort) {
        model.mergeAttributes(userService.getMapAndPageForPatients(pageNo, pageSize, desc, sort));
        return "/medicpanel/user/list";
    }

}
