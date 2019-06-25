package com.samsolutions.service;

import com.samsolutions.entity.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    Role findRoleById(long id);
}
