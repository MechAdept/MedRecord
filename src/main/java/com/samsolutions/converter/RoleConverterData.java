package com.samsolutions.converter;

import com.samsolutions.converter.fromEntity.DataDTOConverter;
import com.samsolutions.dto.data.RoleDataDTO;
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
public class RoleConverterData implements DataDTOConverter<Role, RoleDataDTO> {

    @Autowired
    UserConverterData userConverter;

    @Override
    public RoleDataDTO entityToDataDTO(final Role role) {
        RoleDataDTO roleDTO = new RoleDataDTO();
        try {
            roleDTO.setId(role.getId());
            roleDTO.setName(role.getName());
            return roleDTO;
        } catch (NullPointerException ne) {
            return roleDTO;
        }
    }

    @Override
    public Role formDtoToEntity(final RoleDataDTO source) {
        Role target = new Role();
        target.setId(source.getId());
        target.setName(source.getName());
        try {
            target.setUsers(new HashSet<>(userConverter.formDtoSetToEntities(source.getUsers())));
            return target;
        } catch (NullPointerException ne) {
            return target;
        }
    }

    @Override
    public Set<RoleDataDTO> entitiesToDataDtoSet(final Set<Role> entitySet) {
        Set<RoleDataDTO> DTOSet = new HashSet<>();
        try {
            for (Role source : entitySet) {
                RoleDataDTO target = entityToDataDTO(source);
                DTOSet.add(target);
            }
            return DTOSet;
        } catch (Exception e) {
            return DTOSet;
        }

    }

    @Override
    public Set<Role> formDtoSetToEntities(final Set<RoleDataDTO> roleDTOSet) {
        Set<Role> roleSet = new HashSet<>();
        try {
            for (RoleDataDTO source : roleDTOSet) {
                Role target = formDtoToEntity(source);
                roleSet.add(target);
            }
            return roleSet;
        } catch (NullPointerException ne) {
            return roleSet;
        }
    }

    @Override
    public List<RoleDataDTO> entitiesToDataDtoList(List<Role> entityList) {
        List<RoleDataDTO> DTOList = new ArrayList<>();
        for (Role source : entityList) {
            RoleDataDTO target = entityToDataDTO(source);
            DTOList.add(target);
        }
        return DTOList;
    }
}
