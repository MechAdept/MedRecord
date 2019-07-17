package com.samsolutions.controller.adminPanel;

import com.samsolutions.dto.UserDTO;
import com.samsolutions.service.RoleService;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    @Qualifier("encoder")
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/adminpanel/user/create", method = RequestMethod.POST)
    public String create(@ModelAttribute UserDTO userDTO) {
        userService.save(userDTO);
        return "redirect: /adminpanel/user";
    }

    @RequestMapping(value = "/adminpanel/user", method = RequestMethod.GET)
    public String read(Model model) {
        List<UserDTO> userDTOList = userService.getUsers();
        model.addAttribute("userDTO", new UserDTO());
        model.addAttribute("userDTOList", userDTOList);
        return "crud/usercrud";
    }

    @RequestMapping(value = "/adminpanel/user/update/{id}", method = RequestMethod.GET)
    public String update(@PathVariable("id") Long id, Model model) {
        UserDTO userDTO = userService.findUserById(id);
        model.addAttribute("userDTOForm", new UserDTO());
        model.addAttribute("userDTO", userDTO);
        model.addAttribute("roleDTOSet",new HashSet<>(roleService.getRoles()));
        return "crud/update/userupdate";
    }

    @RequestMapping(value = "/adminpanel/user/update", method = RequestMethod.POST)
    public String updatepost(@ModelAttribute UserDTO userDTO) {
        userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userService.update(userDTO);
        return "redirect: /adminpanel/user";
    }

    @RequestMapping(value = "/adminpanel/user/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect: /adminpanel/user";
    }
}
