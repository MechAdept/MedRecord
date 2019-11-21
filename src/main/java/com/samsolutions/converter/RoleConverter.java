package com.samsolutions.converter;

import com.samsolutions.dto.data.RoleDataDTO;
import com.samsolutions.dto.form.RoleFormDTO;
import com.samsolutions.entity.Role;
import com.samsolutions.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class RoleConverter implements DTOConverter<Role, RoleDataDTO, RoleFormDTO> {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Override
    public RoleDataDTO entityToDataDto(final Role source) {
        RoleDataDTO target = new RoleDataDTO();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setUsers(userConverter.entitiesToDataDtoList(source.getUsers()));
        return target;
    }

    @Override
    public Role formDtoToEntity(final RoleFormDTO source) {
        Role target = new Role();
        target.setId(source.getId());
        target.setName(source.getName());
        try {
            target.setUsers(userRepository.findUsersByIdIn(Arrays.asList(source.getUsers())));
            return target;
        } catch (NullPointerException ne) {
            return target;
        }
    }

    @Override
    public List<RoleDataDTO> entitiesToDataDtoList(final List<Role> sourceList) {
        List<RoleDataDTO> targetList = new ArrayList<>();
        for (Role source : sourceList) {
            RoleDataDTO target = new RoleDataDTO();
            target.setId(source.getId());
            target.setName(source.getName());
            targetList.add(target);
        }
        return targetList;
    }
}
