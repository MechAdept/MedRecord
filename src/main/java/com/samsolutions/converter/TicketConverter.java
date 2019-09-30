package com.samsolutions.converter;

import com.samsolutions.dto.data.TicketDataDTO;
import com.samsolutions.dto.form.TicketFormDTO;
import com.samsolutions.entity.Ticket;
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
public class TicketConverter implements DTOConverter<Ticket, TicketDataDTO, TicketFormDTO> {

    @Autowired
    UserConverter userConverter;

    @Autowired
    UserRepository userRepository;

    @Override
    public TicketDataDTO entityToDataDto(Ticket source) {
        TicketDataDTO target = new TicketDataDTO();
        target.setId(source.getId());
        target.setDoctor(userConverter.entityToDataDto(source.getDoctor()));
        target.setPatient(userConverter.entityToDataDto(source.getPatient()));
        target.setDatetime(source.getDatetime());
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
