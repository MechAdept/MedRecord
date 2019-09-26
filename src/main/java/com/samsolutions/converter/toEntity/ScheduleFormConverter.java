package com.samsolutions.converter.toEntity;

import com.samsolutions.dto.form.ScheduleFormDTO;
import com.samsolutions.entity.Schedule;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class ScheduleFormConverter implements FormDTOConverter<Schedule, ScheduleFormDTO> {

    @Override
    public Schedule formDtoToEntity(ScheduleFormDTO formDto) {
        return null;
    }

    @Override
    public Set<Schedule> formDtoSetToEntities(Set<ScheduleFormDTO> formDtoSet) {
        return null;
    }
}
