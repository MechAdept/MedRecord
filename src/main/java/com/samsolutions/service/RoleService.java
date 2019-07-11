package com.samsolutions.service;

import com.samsolutions.dto.RoleDTO;
import com.samsolutions.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    RoleDTO save(RoleDTO roleDTO);
    RoleDTO findRoleById(Long id);
    Role findRoleByName(String name);

    List<Role> getRoles();
    void deleteRole(Long id);
}
