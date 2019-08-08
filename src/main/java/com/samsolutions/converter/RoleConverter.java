package com.samsolutions.converter;

import com.samsolutions.dto.RoleDTO;
import com.samsolutions.dto.UserDTO;
import com.samsolutions.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Converter for Role.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.converter
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Component
public class RoleConverter implements DTOConverter<Role, RoleDTO> {

    @Autowired
    UserConverter userConverter;

    @Override
    public RoleDTO entityToDTO(final Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());
        return roleDTO;
    }

    @Override
    public Role dtoToEntity(final RoleDTO source) {
        Role target = new Role();
        target.setId(source.getId());
        target.setName(source.getName());
        Set<UserDTO> DTOSet = new HashSet<>(source.getUsers());
        target.setUsers(new HashSet<>(userConverter.dtoSetToEntities(DTOSet)));
        return target;
    }

    @Override
    public Set<RoleDTO> entitiesToDtoSet(final Set<Role> entitySet) {
        Set<RoleDTO> DTOSet = new HashSet<>();
        if (entitySet != null) {
            for (Role source : entitySet) {
                RoleDTO target = entityToDTO(source);
                DTOSet.add(target);
            }
        }
        return DTOSet;
    }

    @Override
    public Set<Role> dtoSetToEntities(final Set<RoleDTO> roleDTOSet) {
        Set<Role> roleSet = new HashSet<>();
        if (!(roleDTOSet == null)) {
            for (RoleDTO source : roleDTOSet) {
                Role target = dtoToEntity(source);
                roleSet.add(target);
            }
        }
        return roleSet;
    }

    @Override
    public List<RoleDTO> entitiesToDtoList(List<Role> entityList) {
        List<RoleDTO> DTOList = new ArrayList<>();
        for (Role source : entityList) {
            RoleDTO target = entityToDTO(source);
            DTOList.add(target);
        }
        return DTOList;
    }
}
