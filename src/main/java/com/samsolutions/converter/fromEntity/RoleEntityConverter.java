package com.samsolutions.converter.fromEntity;

import com.samsolutions.dto.data.RoleDataDTO;
import com.samsolutions.entity.Role;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class RoleEntityConverter implements DataDTOConverter<Role, RoleDataDTO> {
    @Override
    public RoleDataDTO entityToDataDTO(Role entity) {
        return null;
    }

    @Override
    public Set<RoleDataDTO> entitiesToDataDtoSet(Set<Role> entitySet) {
        return null;
    }

    @Override
    public List<RoleDataDTO> entitiesToDataDtoList(List<Role> entityList) {
        return null;
    }
}
