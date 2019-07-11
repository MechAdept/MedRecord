package com.samsolutions.controller;

import com.samsolutions.dto.RoleDTO;
import com.samsolutions.dto.UserDTO;
import com.samsolutions.service.RoleService;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {


    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/adminPanel/role/create", method = RequestMethod.POST)
    public String roleCrud(@ModelAttribute(name = "roleDTO") RoleDTO roleDTO, Model model) {
        roleService.save(roleDTO);
        model.addAttribute(new RoleDTO());
        model.addAttribute("roleList", roleService.getRoles());
        return "adminPanel";
    }

    @RequestMapping(value = "/adminPanel", method = RequestMethod.GET)
    public String adminPanel(Model model) {
        return "adminPanel";
    }

    @RequestMapping(value = "/adminPanel/role", method = RequestMethod.GET)
    public String roleCrud(Model model) {
        model.addAttribute(new RoleDTO());
        model.addAttribute("roleList", roleService.getRoles());
        return "adminPanel";
    }

    @RequestMapping(value = "/adminPanel/role/delete/{id}", method = RequestMethod.GET)
    public String roleCrud(@ModelAttribute("role") RoleDTO roleDTO, @PathVariable("id") Long id, Model model) {
        roleService.deleteRole(id);
        model.addAttribute(new RoleDTO());
        model.addAttribute("roleList", roleService.getRoles());
        return "adminPanel";
    }

    @RequestMapping(value = "/adminPanel/user", method = RequestMethod.GET)
    public String userCrud(Model model) {
        model.addAttribute("userList", userService.getUsers());
        return "adminPanel";
    }

    @RequestMapping(value = "/adminPanel/user/delete/{id}", method = RequestMethod.GET)
    public String roleCrud(@ModelAttribute("user") UserDTO userDTO, @PathVariable("id") Long id, Model model) {
        userService.delete(id);
        model.addAttribute("userList", userService.getUsers());
        return "adminPanel";
    }
}
