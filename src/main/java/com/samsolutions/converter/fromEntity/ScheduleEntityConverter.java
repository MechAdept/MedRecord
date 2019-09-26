package com.samsolutions.converter.fromEntity;

import com.samsolutions.dto.data.ScheduleDataDTO;
import com.samsolutions.entity.Schedule;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class ScheduleEntityConverter implements DataDTOConverter<Schedule, ScheduleDataDTO> {

    @Override
    public ScheduleDataDTO entityToDataDTO(Schedule entity) {
        return null;
    }

    @Override
    public Set<ScheduleDataDTO> entitiesToDataDtoSet(Set<Schedule> entitySet) {
        return null;
    }

    @Override
    public List<ScheduleDataDTO> entitiesToDataDtoList(List<Schedule> entityList) {
        return null;
    }
}
