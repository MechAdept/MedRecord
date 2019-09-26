package com.samsolutions.converter;

import com.samsolutions.converter.fromEntity.DataDTOConverter;
import com.samsolutions.dto.data.VisitDataDTO;
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
public class VisitConverterData implements DataDTOConverter<Visit, VisitDataDTO> {

    @Autowired
    private TicketConverterData ticketConverter;

    @Override
    public VisitDataDTO entityToDataDTO(final Visit source) {

        VisitDataDTO target = new VisitDataDTO();
        try {
            target.setId(source.getId());
            target.setDatetime(source.getDatetime());
            target.setComplaint(source.getComplaint());
            target.setDiagnosis(source.getDiagnosis());
            target.setExamination(source.getExamination());
            target.setTreatment(source.getTreatment());
            target.setTicket(ticketConverter.entityToDataDTO(source.getTicket()));
        } catch (NullPointerException ne){
            return new VisitDataDTO();
        }
        return target;
    }

    @Override
    public Visit formDtoToEntity(final VisitDataDTO source) {
        Visit target = new Visit();
        target.setId(source.getId());
        target.setDatetime(source.getDatetime());
        target.setComplaint(source.getComplaint());
        target.setDiagnosis(source.getDiagnosis());
        target.setExamination(source.getExamination());
        target.setTreatment(source.getTreatment());
        target.setTicket(ticketConverter.formDtoToEntity(source.getTicket()));
        return target;
    }

    @Override
    public Set<VisitDataDTO> entitiesToDataDtoSet(final Set<Visit> entitySet) {
        Set<VisitDataDTO> DTOSet = new HashSet<>();
        for (Visit source : entitySet) {
            VisitDataDTO target = entityToDataDTO(source);
            DTOSet.add(target);
        }
        return DTOSet;
    }

    @Override
    public Set<Visit> formDtoSetToEntities(final Set<VisitDataDTO> DTOSet) {
        Set<Visit> entitySet = new HashSet<>();
        for (VisitDataDTO source : DTOSet) {
            Visit target = formDtoToEntity(source);
            entitySet.add(target);
        }
        return entitySet;
    }

    @Override
    public List<VisitDataDTO> entitiesToDataDtoList(List<Visit> entityList) {
        List<VisitDataDTO> DTOList = new ArrayList<>();
        for (Visit source : entityList) {
            VisitDataDTO target = entityToDataDTO(source);
            DTOList.add(target);
        }
        return DTOList;
    }
}

