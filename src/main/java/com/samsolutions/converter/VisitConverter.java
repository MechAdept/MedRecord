package com.samsolutions.converter;

import com.samsolutions.dto.data.VisitDataDTO;
import com.samsolutions.dto.form.VisitFormDTO;
import com.samsolutions.entity.Visit;
import com.samsolutions.repository.TicketRepository;
import com.samsolutions.service.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class VisitConverter implements DTOConverter<Visit, VisitDataDTO, VisitFormDTO> {

    @Autowired
    TicketConverter ticketConverter;

    @Autowired
    TicketRepository ticketRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public VisitDataDTO entityToDataDto(Visit source) {
        VisitDataDTO target = new VisitDataDTO();
        try {
            target.setId(source.getId());
        } catch (NullPointerException ne) {
            logger.debug("Visit not exist");
            return target;
        }
        target.setDatetime(source.getDatetime());
        target.setComplaint(source.getComplaint());
        target.setExamination(source.getExamination());
        target.setDiagnosis(source.getDiagnosis());
        target.setTreatment(source.getTreatment());
        return target;
    }

    @Override
    public Visit formDtoToEntity(VisitFormDTO source) {
        Visit target = new Visit();
        target.setId(source.getId());
        target.setTicket(ticketRepository.getOne(source.getTicketId()));
        target.setDatetime(LocalDateTime.parse(source.getDatetime(), DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        target.setComplaint(source.getComplaint());
        target.setExamination(source.getExamination());
        target.setDiagnosis(source.getDiagnosis());
        target.setTreatment(source.getTreatment());
        return target;
    }

    @Override
    public List<VisitDataDTO> entitiesToDataDtoList(List<Visit> sourceList) {
        List<VisitDataDTO> targetList = new ArrayList<>();
        for (Visit source : sourceList) {
            VisitDataDTO target = entityToDataDto(source);
            targetList.add(target);
        }
        return targetList;
    }
}
