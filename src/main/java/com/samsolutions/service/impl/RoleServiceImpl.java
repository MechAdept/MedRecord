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

@Service("RoleService")
public class RoleServiceImpl implements RoleService {
    @Autowired
    @Qualifier("roleRepository")
    private RoleRepository roleRepository;

    private DTOConverter<Role,RoleDTO> converter= new RoleConverter();

    @Override
    public void save(RoleDTO roleDTO) {
        Role role = converter.DTOToEntity(roleDTO);
        roleRepository.save(role);
    }

    @Override
    @Transactional(readOnly = true)
    public RoleDTO findRoleById(Long id) {
        return converter.EntityToDTO(roleRepository.findOne(id));
    }

    @Override
    public List<RoleDTO> getRoles() {
        return  converter.EListToDTO(roleRepository.findAll());
    }

    @Override
    @Transactional
    public void update(RoleDTO roleDTO) {
        Role role =  converter.DTOToEntity(roleDTO);
        roleRepository.updateProduct(role.getId(),role.getName());
    }

    @Override
    @Transactional
    public void deleteRole(Long id) {
        roleRepository.delete(id);
    }
}
