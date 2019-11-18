package com.samsolutions.converter;

import com.samsolutions.dto.data.TicketDataDTO;
import com.samsolutions.dto.form.TicketFormDTO;
import com.samsolutions.entity.Ticket;
import com.samsolutions.repository.UserRepository;
import com.samsolutions.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class TicketConverter implements DTOConverter<Ticket, TicketDataDTO, TicketFormDTO> {

    @Autowired
    UserConverter userConverter;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VisitConverter visitConverter;

    private static final Logger logger = LoggerFactory.getLogger(TicketConverter.class);

    @Override
    public TicketDataDTO entityToDataDto(Ticket source) {
        TicketDataDTO target = new TicketDataDTO();
        try {
            target.setId(source.getId());
        } catch (NullPointerException ne) {
            logger.debug("Ticket does not have a id");
        }
        try {
            target.setDoctor(userConverter.entityToDataDto(source.getDoctor()));
        } catch (NullPointerException ne) {
            logger.debug("Ticket does not have a doctor");
        }
        try {
            target.setPatient(userConverter.entityToDataDto(source.getPatient()));
        } catch (NullPointerException ne) {
            logger.debug("Ticket does not have a patient");
        }
        try {
            target.setDatetime(source.getDatetime());
        } catch (NullPointerException ne)
        {
            logger.debug("Ticket does not have a datetime");
        }
        try {
            target.setVisit(visitConverter.entityToDataDto(source.getVisit()));
        } catch (NullPointerException ne) {
            logger.debug("Ticket does not have a visit");
        }
        try {
            target.setAttendance(source.getAttendance());
        } catch (NullPointerException ne) {
            logger.debug("Ticket does not have a Attendance");
        }
        return target;
    }

    @Override
    public Ticket formDtoToEntity(TicketFormDTO source) {
        Ticket target = new Ticket();
        target.setId(source.getId());
        target.setDoctor(userRepository.getOne(source.getDoctorId()));
        target.setPatient(userRepository.getOne(source.getPatientId()));
        target.setDatetime(LocalDateTime.parse(source.getDatetime(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
        return target;
    }

    @Override
    public List<TicketDataDTO> entitiesToDataDtoList(List<Ticket> sourceList) {
        List<TicketDataDTO> targetList = new ArrayList<>();
        for (Ticket source : sourceList) {
            TicketDataDTO target = entityToDataDto(source);
            targetList.add(target);
        }
        return targetList;
    }
}
