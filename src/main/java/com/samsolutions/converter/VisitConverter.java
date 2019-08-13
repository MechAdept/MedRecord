package com.samsolutions.converter;

import com.samsolutions.dto.VisitDTO;
import com.samsolutions.entity.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Converter for Visit.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.converter
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Component
public class VisitConverter implements DTOConverter<Visit, VisitDTO> {

    @Autowired
    private TicketConverter ticketConverter;

    @Override
    public VisitDTO entityToDTO(final Visit source) {
        VisitDTO target = new VisitDTO();
        target.setId(source.getId());
        target.setDatetime(source.getDatetime());
        target.setComplaint(source.getComplaint());
        target.setDiagnosis(source.getDiagnosis());
        target.setExamination(source.getExamination());
        target.setTreatment(source.getTreatment());
        target.setTicket(ticketConverter.entityToDTO(source.getTicket()));
        return target;
    }

    @Override
    public Visit dtoToEntity(final VisitDTO source) {
        Visit target = new Visit();
        target.setId(source.getId());
        target.setDatetime(source.getDatetime());
        target.setComplaint(source.getComplaint());
        target.setDiagnosis(source.getDiagnosis());
        target.setExamination(source.getExamination());
        target.setTreatment(source.getTreatment());
        target.setTicket(ticketConverter.dtoToEntity(source.getTicket()));
        return target;
    }

    @Override
    public Set<VisitDTO> entitiesToDtoSet(final Set<Visit> entitySet) {
        Set<VisitDTO> DTOSet = new HashSet<>();
        for (Visit source : entitySet) {
            VisitDTO target = entityToDTO(source);
            DTOSet.add(target);
        }
        return DTOSet;
    }

    @Override
    public Set<Visit> dtoSetToEntities(final Set<VisitDTO> DTOSet) {
        Set<Visit> entitySet = new HashSet<>();
        for (VisitDTO source : DTOSet) {
            Visit target = dtoToEntity(source);
            entitySet.add(target);
        }
        return entitySet;
    }

    @Override
    public List<VisitDTO> entitiesToDtoList(List<Visit> entityList) {
        List<VisitDTO> DTOList = new ArrayList<>();
        for (Visit source : entityList) {
            VisitDTO target = entityToDTO(source);
            DTOList.add(target);
        }
        return DTOList;
    }
}

