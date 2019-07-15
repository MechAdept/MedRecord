package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.RoleDTO;
import com.samsolutions.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/adminpanel/role/create", method = RequestMethod.POST)
    public String roleCrud(@ModelAttribute(name = "roleDTO") RoleDTO roleDTO, Model model) {
        roleService.save(roleDTO);
        return "redirect: /adminpanel/role";
    }

    @RequestMapping(value = "/adminpanel/role", method = RequestMethod.GET)
    public String roleCrud(Model model) {
        List<RoleDTO> roleDTOList = roleService.getRoles();
        model.addAttribute("roleDTOForm", new RoleDTO());
        model.addAttribute("roleDTOList", roleDTOList);
        return "crud/rolecrud";
    }

    @RequestMapping(value = "/adminpanel/role/update/{id}", method = RequestMethod.GET)
    public String roleUpdate(@PathVariable("id") Long id, Model model) {
        RoleDTO roleDTO = roleService.findRoleById(id);
        model.addAttribute("roleDTO", roleDTO);
        model.addAttribute("roleDTOForm", new RoleDTO());
        return "crud/update/roleupdate";
    }

    @RequestMapping(value = "adminpanel/roleupdate/action", method = RequestMethod.POST)
    public String roleUpdate(@ModelAttribute RoleDTO roleDTO, Model model) {
        roleService.update(roleDTO);
        return "redirect: /adminpanel/role";
    }

    @RequestMapping(value = "/adminpanel/role/delete/{id}", method = RequestMethod.GET)
    public String roleCrud(@PathVariable("id") Long id, Model model) {
        roleService.deleteRole(id);
        return "redirect: /adminpanel/role";
    }
}
