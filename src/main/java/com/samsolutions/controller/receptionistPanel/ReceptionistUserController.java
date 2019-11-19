package com.samsolutions.controller.receptionistPanel;

import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.service.UserService;
import groovy.transform.TailRecursive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Secured("ROLE_RECEPTIONIST")
@RequestMapping("/receptionistpanel/user")
public class ReceptionistUserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/create")
    public String create(Model model) {
        return "";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public String create(@ModelAttribute("userFormDTO") final UserFormDTO userFormDTO) {
        return "";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}/delete")
    public String delete(@PathVariable("userId") final Long userId) {
        return "";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{userId}/updatePhoto")
    public String updatePhoto(@PathVariable("userId") final Long userId) {
        return "";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{userId}/updatePassword")
    public String updatePassword(@PathVariable("userId") final Long userId) {
        return "";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/{userId}/updateRoles")
    public String updateRoles(@PathVariable("userId") final Long userId) {
        return "";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}")
    public String details() {
        return "";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/update")
    public String update() {
        return "";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{userId}/update")
    public String update(@PathVariable("userId") final Long userId) {
        return "";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/patients")
    public String patients() {

        return "";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/doctors")
    public String doctors() {
        return "";
    }

}
