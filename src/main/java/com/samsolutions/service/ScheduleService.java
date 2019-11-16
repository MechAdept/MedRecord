package com.samsolutions.service;

import com.samsolutions.dto.data.ScheduleDataDTO;
import com.samsolutions.dto.form.UserFormDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface ScheduleService {

    List<ScheduleDataDTO> getDayByDateAndId(String date, Long id);

    Boolean booking(Long patientId, Long scheduleId);

    List<ScheduleDataDTO> getDayBySchedule(Long scheduleId);

    void fillMonth(UserFormDTO userFormDTO);

    void deleteOldSchedule();

    void addNewSchedule();

    void blockSchedule();

    void changeAvailableById(Long id);

    Map<String, Object> bookingPreparation();
}
