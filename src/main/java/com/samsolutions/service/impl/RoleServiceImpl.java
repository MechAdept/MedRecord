package com.samsolutions.service.impl;

import com.samsolutions.converter.RoleConverter;
import com.samsolutions.dto.RoleDTO;
import com.samsolutions.entity.Role;
import com.samsolutions.entity.User;
import com.samsolutions.repository.RoleRepository;
import com.samsolutions.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Implements the methods defined in the role service.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service.impl
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Service("RoleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleConverter roleConverter;

    @Override
    public void save(final RoleDTO roleDTO) {
        Role role = roleConverter.dtoToEntity(roleDTO);
        roleRepository.save(role);
    }

    @Override
    public RoleDTO findRoleById(final Long id) {
        return roleConverter.entityToDTO(roleRepository.getOne(id));
    }

    @Override
    public List<RoleDTO> getRoles() {
        return roleConverter.entitiesToDtoList(roleRepository.findAll());
    }

    @Override
    public void deleteRole(final Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Set<Role> getRolesEntityByUserId(User user) {
        return new HashSet<>(roleRepository.getRolesByUsers(user));
    }
}
