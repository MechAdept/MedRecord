package com.samsolutions.service.impl;

import com.samsolutions.dto.RoleDTO;
import com.samsolutions.entity.Role;
import com.samsolutions.repository.RoleRepository;
import com.samsolutions.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("RoleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    @Qualifier("roleRepository")
    private RoleRepository roleRepository;

    @Override
    public RoleDTO save(RoleDTO roleDTO) {
        Role roleEntity = new Role();
        BeanUtils.copyProperties(roleDTO, roleEntity);
        roleEntity = roleRepository.save(roleEntity);
        BeanUtils.copyProperties(roleEntity, roleDTO);
        return roleDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public RoleDTO findRoleById(Long id) {
        RoleDTO roleDTO = new RoleDTO();
        Role role = roleRepository.findOne(id);
        BeanUtils.copyProperties(role, roleDTO);
        return roleDTO;
    }

    @Override
    @Transactional(readOnly = true)
    public Role findRoleByName(String name) {
        return findRoleByName(name);
    }

    @Override
    public List<Role> getRoles() {
        return  roleRepository.findAll();
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.delete(id);
    }
}
