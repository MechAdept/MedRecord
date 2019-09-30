package com.samsolutions.converter;

import com.samsolutions.dto.data.ScheduleDataDTO;
import com.samsolutions.dto.form.ScheduleFormDTO;
import com.samsolutions.entity.Schedule;
import com.samsolutions.repository.TicketRepository;
import com.samsolutions.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class ScheduleConverter implements DTOConverter<Schedule, ScheduleDataDTO, ScheduleFormDTO> {

    @Autowired
    UserConverter userConverter;

    @Autowired
    TicketConverter ticketConverter;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Override
    public ScheduleDataDTO entityToDataDto(Schedule source) {
        ScheduleDataDTO target = new ScheduleDataDTO();
        target.setId(source.getId());
        target.setDoctor(userConverter.entityToDataDto(source.getDoctor()));
        target.setTicket(ticketConverter.entityToDataDto(source.getTicket()));
        target.setDatetime(source.getDatetime());
        target.setAvailable(source.getAvailable());
        return target;
    }

    @Override
    public Schedule formDtoToEntity(ScheduleFormDTO source) {
        Schedule target = new Schedule();
        target.setId(source.getId());
        target.setDoctor(userRepository.getOne(source.getDoctorId()));
        target.setTicket(ticketRepository.getOne(source.getTicketId()));
        target.setDatetime(LocalDateTime.parse(source.getDatetime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        target.setAvailable(source.getAvailable());
        return target;
    }

    @Override
    public List<ScheduleDataDTO> entitiesToDataDtoList(List<Schedule> sourceList) {
        List<ScheduleDataDTO> targetList = new ArrayList<>();
        try {
            for (Schedule source : sourceList) {
                ScheduleDataDTO target = entityToDataDto(source);
                targetList.add(target);
            }
            return targetList;
        } catch (NullPointerException ne) {
            return targetList;
        }
    }
}
