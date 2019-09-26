package com.samsolutions.converter.toEntity;

import com.samsolutions.dto.form.HealthFormDTO;
import com.samsolutions.entity.Health;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class HealthFormConverter implements FormDTOConverter<Health, HealthFormDTO> {

    @Override
    public Health formDtoToEntity(HealthFormDTO formDto) {
        return null;
    }

    @Override
    public Set<Health> formDtoSetToEntities(Set<HealthFormDTO> formDtoSet) {
        return null;
    }
}
