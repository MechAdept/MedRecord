package com.samsolutions.converter.toEntity;

import com.samsolutions.dto.form.VisitFormDTO;
import com.samsolutions.entity.Visit;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class VisitFormConverter implements FormDTOConverter<Visit, VisitFormDTO> {

    @Override
    public Visit formDtoToEntity(VisitFormDTO formDto) {
        return null;
    }

    @Override
    public Set<Visit> formDtoSetToEntities(Set<VisitFormDTO> formDtoSet) {
        return null;
    }
}
