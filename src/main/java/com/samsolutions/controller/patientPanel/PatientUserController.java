package com.samsolutions.controller.patientPanel;

import com.samsolutions.dto.form.UserFormDTO;
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

@RequestMapping("/patientpanel")
@Controller
@Secured("ROLE_PATIENT")
public class PatientUserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserPasswordValidator userPasswordValidator;

    @RequestMapping(method = RequestMethod.GET, value = "/profile")
    public String profile(Model model) {
        model.addAttribute("userDataDTO", userService.getCurrent());
        model.addAttribute("userFormDTO", new UserFormDTO());
        model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
        return "patientpanel/user/profile";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updatephoto")
    public String updatePhoto(@RequestParam("file") MultipartFile file) throws IOException {
        userService.updatePhoto(userService.getCurrent().getId(), file);
        return "redirect:/patientpanel/profile";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/doctor/{doctorId}")
    public String doctorProfile(Model model, @PathVariable("doctorId") Long doctorId) {
        model.addAttribute("userDataDTO", userService.findById(doctorId));
        model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
        return "patientpanel/user/details";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/updatepass")
    public String updatePassword(final Model model, @ModelAttribute("userFormDTO") final UserFormDTO userFormDTO, final BindingResult bindingResult) {
        userPasswordValidator.validate(userFormDTO, bindingResult);
        if ((bindingResult.hasErrors())) {
            model.addAttribute("formatter", new SimpleDateFormat("yyyy-MM-dd"));
            model.addAttribute("userDataDTO", userService.getCurrent());
            return "patientpanel/user/profile";
        }
        userService.updatePassword(userFormDTO);
        return "redirect:/patientpanel/profile";
    }
}
