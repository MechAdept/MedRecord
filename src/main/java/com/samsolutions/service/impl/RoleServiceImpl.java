package com.samsolutions.service.impl;

import com.samsolutions.entity.Role;
import com.samsolutions.repository.RoleRepository;
import com.samsolutions.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("RoleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    @Qualifier("roleRepository")
    private RoleRepository roleRepository;

    @Override
    @Transactional(readOnly = true)
    public Role findRoleById(int id) {
        return roleRepository.findOne(id);
    }
}
