package com.samsolutions.converter.fromEntity;

import com.samsolutions.dto.data.HealthDataDTO;
import com.samsolutions.entity.Health;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class HealthEntityConverter implements DataDTOConverter<Health, HealthDataDTO>{

    @Override
    public HealthDataDTO entityToDataDTO(Health entity) {
        return null;
    }

    @Override
    public Set<HealthDataDTO> entitiesToDataDtoSet(Set<Health> entitySet) {
        return null;
    }

    @Override
    public List<HealthDataDTO> entitiesToDataDtoList(List<Health> entityList) {
        return null;
    }
}
