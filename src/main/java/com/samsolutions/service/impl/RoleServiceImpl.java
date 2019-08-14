package com.samsolutions.service.impl;

import com.samsolutions.converter.RoleConverter;
import com.samsolutions.converter.UserConverter;
import com.samsolutions.dto.RoleDTO;
import com.samsolutions.dto.UserDTO;
import com.samsolutions.entity.Role;
import com.samsolutions.repository.RoleRepository;
import com.samsolutions.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
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
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleConverter roleConverter;

    @Autowired
    private UserConverter userConverter;

    @Override
    public void save(final RoleDTO roleDTO) {
        Role role = roleConverter.dtoToEntity(roleDTO);
        roleRepository.save(role);
    }

    @Override
    public RoleDTO findRoleById(final Long id) {

        Role role = roleRepository.findById(id).orElse(new Role());
        return roleConverter.entityToDTO(role);
    }

    @Override
    public Set<RoleDTO> findRolesById(Long[] rolesId) {
        Set<RoleDTO> roleDTOSet = new java.util.HashSet<>(Collections.emptySet());
        try {
            for (Long id : rolesId) {
                roleDTOSet.add((findRoleById(id)));
            }
            return roleDTOSet;
        } catch (NullPointerException ne) {
            return roleDTOSet;
        }
    }

    public List<RoleDTO> getPage(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Pageable pageable = getPageable(pageNo, pageSize, desc, sort);
        Page<Role> pagedResult = roleRepository.findAll(pageable);
        if (pagedResult.hasContent()) {
            return roleConverter.entitiesToDtoList(pagedResult.getContent());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public void deleteRole(final Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<RoleDTO> getRolesByUser(UserDTO userDTO) {
        return roleConverter.entitiesToDtoList(roleRepository.getRolesByUsers(
                userConverter.dtoToEntity(userDTO)));
    }

    @Override
    public Long getPageCount(Integer pageSize) {
        return roleRepository.count() / pageSize;
    }

    @Override
    public Long getTotalCount() {
        return roleRepository.count();
    }

    @Override
    public List<RoleDTO> findAll() {
        return roleConverter.entitiesToDtoList(roleRepository.findAll(Sort.by("id").ascending()));
    }

    @Override
    public RoleDTO findRoleByName(String name) {
        return roleConverter.entityToDTO(roleRepository.findRoleByName(name));
    }

    private Pageable getPageable(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Pageable pageable;
        if (desc) {
            pageable = PageRequest.of(pageNo, pageSize, Sort.by(sort).descending());
        } else {
            pageable = PageRequest.of(pageNo, pageSize, Sort.by(sort).ascending());
        }
        return pageable;
    }
}
