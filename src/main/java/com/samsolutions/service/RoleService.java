package com.samsolutions.service;

import com.samsolutions.dto.RoleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    void update(RoleDTO role);

    void save(RoleDTO role);

    RoleDTO findRoleById(Long id);

    List<RoleDTO> getRoles();

    void deleteRole(Long id);
}
