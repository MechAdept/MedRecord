package com.samsolutions.service;

import com.samsolutions.dto.data.ScheduleDataDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ScheduleService {

    List<ScheduleDataDTO> getDayByDateAndId(String date, Long id);

    Boolean booking(Long patientId, Long scheduleId);

    List<ScheduleDataDTO> getDayBySchedule(Long scheduleId);
}
