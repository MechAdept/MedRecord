package com.samsolutions.converter.fromEntity;

import com.samsolutions.dto.data.VisitDataDTO;
import com.samsolutions.entity.Visit;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class VisitEntityConverter implements DataDTOConverter<Visit, VisitDataDTO> {

    @Override
    public VisitDataDTO entityToDataDTO(Visit entity) {
        return null;
    }

    @Override
    public Set<VisitDataDTO> entitiesToDataDtoSet(Set<Visit> entitySet) {
        return null;
    }

    @Override
    public List<VisitDataDTO> entitiesToDataDtoList(List<Visit> entityList) {
        return null;
    }
}
