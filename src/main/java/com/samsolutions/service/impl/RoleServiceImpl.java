package com.samsolutions.service.impl;

import com.samsolutions.converter.DTOConverter;
import com.samsolutions.converter.RoleConverter;
import com.samsolutions.dto.RoleDTO;
import com.samsolutions.entity.Role;
import com.samsolutions.repository.RoleRepository;
import com.samsolutions.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Qualifier("roleRepository")
    private RoleRepository roleRepository;

    private DTOConverter<Role, RoleDTO> converter = new RoleConverter();

    @Override
    public void save(final RoleDTO roleDTO) {
        Role role = converter.dtoToEntity(roleDTO);
        roleRepository.save(role);
    }

    @Override
    @Transactional(readOnly = true)
    public RoleDTO findRoleById(final Long id) {
        return converter.entityToDTO(roleRepository.findOne(id));
    }

    @Override
    public List<RoleDTO> getRoles() {
        return converter.entitiesToDtoList(roleRepository.findAll());
    }

    @Override
    @Transactional
    public void update(final RoleDTO roleDTO) {
        Role role = converter.dtoToEntity(roleDTO);
        roleRepository.updateRole(role.getId(), role.getName());
    }

    @Override
    @Transactional
    public void deleteRole(final Long id) {
        roleRepository.delete(id);
    }
}
