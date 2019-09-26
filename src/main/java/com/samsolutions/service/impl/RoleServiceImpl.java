package com.samsolutions.service.impl;

import com.samsolutions.converter.RoleConverterData;
import com.samsolutions.converter.UserConverterData;
import com.samsolutions.dto.RoleDTO;
import com.samsolutions.dto.data.UserDTO;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private RoleConverterData roleConverter;

    @Autowired
    private UserConverterData userConverter;

    @Override
    public void save(final RoleDTO roleDTO) {
        Role role = roleConverter.formDtoToEntity(roleDTO);
        roleRepository.save(role);
    }

    @Override
    public RoleDTO findById(final Long id) {

        Role role = roleRepository.findById(id).orElse(new Role());
        return roleConverter.entityToDataDTO(role);
    }

    @Override
    public Set<RoleDTO> findRolesById(Long[] rolesId) {
        Set<RoleDTO> roleDTOSet = new java.util.HashSet<>(Collections.emptySet());
        try {
            for (Long id : rolesId) {
                roleDTOSet.add((findById(id)));
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
            return roleConverter.entitiesToDataDtoList(pagedResult.getContent());
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
        return roleConverter.entitiesToDataDtoList(roleRepository.getRolesByUsers(
                userConverter.formDtoToEntity(userDTO)));
    }

    @Override
    public List<RoleDTO> findAll() {
        return roleConverter.entitiesToDataDtoList(roleRepository.findAll(Sort.by("id").ascending()));
    }

    @Override
    public RoleDTO findRoleByName(String name) {
        return roleConverter.entityToDataDTO(roleRepository.findRoleByName(name));
    }

    @Override
    public Map<String, Object> getMapAndPage(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Map<String, Object> map = new HashMap<>();
        map.put("DTOList", getPage(pageNo, pageSize, desc, sort));
        map.put("pageNo", pageNo);
        map.put("pageSize", pageSize);
        map.put("desc", desc);
        map.put("sort", sort);
        map.put("pageCount", getPageCount(pageSize));
        map.put("elementsCount", getTotalCount());
        return map;
    }

    private Pageable getPageable(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Pageable pageable;
        if (desc) {
            pageable = PageRequest.of(pageNo-1, pageSize, Sort.by(sort).descending());
        } else {
            pageable = PageRequest.of(pageNo-1, pageSize, Sort.by(sort).ascending());
        }
        return pageable;
    }

    private Long getPageCount(Integer pageSize) {
        return roleRepository.count() / pageSize;
    }

    private Long getTotalCount() {
        return roleRepository.count();
    }
}
