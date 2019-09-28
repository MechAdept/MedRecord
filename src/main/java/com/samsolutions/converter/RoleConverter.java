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
    UserRepository userRepository;

    @Autowired
    UserConverter userConverter;

    @Override
    public RoleDataDTO entityToDataDto(Role source) {
        RoleDataDTO target = new RoleDataDTO();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setUsers(userConverter.entitiesToDataDtoSet(source.getUsers()));
        return target;
    }

    @Override
    public Role formDtoToEntity(RoleFormDTO source) {
        Role target = new Role();
        target.setId(source.getId());
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        try {
            target.setUsers(userRepository.findUsersByIdIn(Arrays.asList(source.getUsers())));
            return target;
        } catch (NullPointerException ne) {
            return target;
        }
    }

    @Override
    public Set<RoleDataDTO> entitiesToDataDtoSet(Set<Role> sourceSet) {
        Set<RoleDataDTO> targetSet = new HashSet<>();
        for (Role source : sourceSet) {
            RoleDataDTO target = entityToDataDto(source);
            targetSet.add(target);
        }
        return targetSet;
    }

    @Override
    public List<RoleDataDTO> entitiesToDataDtoList(List<Role> sourceList) {
        List<RoleDataDTO> targetList = new ArrayList<>();
        for (Role source : sourceList) {
            RoleDataDTO target = entityToDataDto(source);
            targetList.add(target);
        }
        return targetList;
    }

    @Override
    public Set<Role> formDtoSetToEntities(Set<RoleFormDTO> sourceSet) {
        Set<Role> targetSet = new HashSet<>();
        for (RoleFormDTO source : sourceSet) {
            Role target = formDtoToEntity(source);
            targetSet.add(target);
        }
        return targetSet;
    }
}
