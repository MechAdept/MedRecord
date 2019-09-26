package com.samsolutions.converter.toEntity;

import com.samsolutions.dto.form.RoleFormDTO;
import com.samsolutions.entity.Role;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class RoleFormConverter implements FormDTOConverter<Role, RoleFormDTO> {

    @Override
    public Role formDtoToEntity(RoleFormDTO formDto) {
        return null;
    }

    @Override
    public Set<Role> formDtoSetToEntities(Set<RoleFormDTO> formDtoSet) {
        return null;
    }
}
