package com.samsolutions.converter;

import com.samsolutions.dto.TicketDTO;
import com.samsolutions.dto.VisitDTO;
import com.samsolutions.entity.Ticket;
import com.samsolutions.entity.Visit;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter for Visit.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.converter
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

public class VisitConverter implements DTOConverter<Visit, VisitDTO> {
    private DTOConverter<Ticket, TicketDTO> ticketConverter = new TicketConverter();

    @Override
    public VisitDTO entityToDTO(final Visit visit) {
        VisitDTO visitDTO = new VisitDTO();
        BeanUtils.copyProperties(visit, visitDTO);
        return visitDTO;
    }

    @Override
    public Visit dtoToEntity(final VisitDTO visitDTO) {
        Visit visit = new Visit();
        BeanUtils.copyProperties(visitDTO, visit);
        return visit;
    }

    @Override
    public List<VisitDTO> entitiesToDtoList(final List<Visit> entityList) {
        List<VisitDTO> visitDTOList = new ArrayList<>();
        for (Visit source : entityList) {
            VisitDTO target = new VisitDTO();
            BeanUtils.copyProperties(source, target);
            target.setTicket(ticketConverter.entityToDTO(source.getTicket()));
            visitDTOList.add(target);
        }
        return visitDTOList;
    }

    @Override
    public List<Visit> dtoListToEntities(final List<VisitDTO> visitDTOList) {
        List<Visit> visitList = new ArrayList<>();
        for (VisitDTO source : visitDTOList) {
            Visit target = new Visit();
            BeanUtils.copyProperties(source, target);
            visitList.add(target);
        }
        return visitList;
    }

//    @Override
//    public String DTOToJSON(VisitDTO visitDTO) {
//        String json = "";
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            json = mapper.writeValueAsString(visitDTO);
//        } catch (JsonProcessingException e) {
//            System.out.println("Не удалось конвертировать в JSON"); //TODO: Add logger
//        }
//        return json;
//    }
//
//    @Override
//    public VisitDTO JSONToDTO(String json) {
//        ObjectMapper mapper = new ObjectMapper();
//        VisitDTO visitDTO = null;
//        try {
//            visitDTO = mapper.readValue(json, VisitDTO.class);
//        } catch (IOException e) {
//            System.out.println("Не удалось конвертировать в DTO"); //TODO: Add logger
//        }
//        return visitDTO;
//    }
}

