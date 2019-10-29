package com.samsolutions.service.impl;

import com.samsolutions.converter.RoleConverter;
import com.samsolutions.converter.UserConverter;
import com.samsolutions.dto.data.RoleDataDTO;
import com.samsolutions.dto.form.RoleFormDTO;
import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.entity.Role;
import com.samsolutions.repository.RoleRepository;
import com.samsolutions.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Implements the methods defined in the role service.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service.impl
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleConverter roleConverter;

    @Override
    @Transactional(readOnly = true)
    public RoleDataDTO findById(Long id) {
        Role role = roleRepository.findById(id).orElse(new Role());
        return roleConverter.entityToDataDto(role);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> findByIds(Long[] ids) {
        return roleRepository.findRolesByIdIn(Arrays.asList(ids));
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleDataDTO> findAll() {
        return roleConverter.entitiesToDataDtoList(roleRepository.findAll(Sort.by("id").ascending()));
    }

//    @Override
//    public List<Role> getByName(String name) {
//        return Arrays.asList(roleRepository.findRoleByName(name));
//    }
}
