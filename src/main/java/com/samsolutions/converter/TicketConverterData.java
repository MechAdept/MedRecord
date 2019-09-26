package com.samsolutions.converter;

import com.samsolutions.converter.fromEntity.DataDTOConverter;
import com.samsolutions.dto.data.TicketDataDTO;
import com.samsolutions.dto.data.UserDataDTO;
import com.samsolutions.entity.Ticket;
import com.samsolutions.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Converter for Ticket.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.converter
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Component
public class TicketConverterData implements DataDTOConverter<Ticket, TicketDataDTO> {

    @Autowired
    private DataDTOConverter<User, UserDataDTO> userConverter;

    @Override
    public TicketDataDTO entityToDataDTO(final Ticket source) {
        TicketDataDTO target = new TicketDataDTO();
        target.setId(source.getId());
        target.setDatetime(source.getDatetime());
        target.setPatient(userConverter.entityToDataDTO(source.getPatient()));
        target.setDoctor(userConverter.entityToDataDTO(source.getDoctor()));
        return target;
    }

    @Override
    public Ticket formDtoToEntity(final TicketDataDTO source) {
        Ticket target = new Ticket();
        target.setId(source.getId());
        target.setDatetime(source.getDatetime());
        target.setDoctor(userConverter.formDtoToEntity(source.getDoctor()));
        target.setPatient(userConverter.formDtoToEntity(source.getPatient()));
        return target;
    }

    @Override
    public Set<TicketDataDTO> entitiesToDataDtoSet(final Set<Ticket> entitySet) {
        Set<TicketDataDTO> DTOSet = new HashSet<>();
        for (Ticket source : entitySet) {
            TicketDataDTO target = entityToDataDTO(source);
            DTOSet.add(target);
        }
        return DTOSet;
    }

    @Override
    public Set<Ticket> formDtoSetToEntities(final Set<TicketDataDTO> ticketDataDTOSet) {
        Set<Ticket> entitySet = new HashSet<>();
        for (TicketDataDTO source : ticketDataDTOSet) {
            Ticket target = formDtoToEntity(source);
            entitySet.add(target);
        }
        return entitySet;
    }

    @Override
    public List<TicketDataDTO> entitiesToDataDtoList(List<Ticket> entityList) {
        List<TicketDataDTO> DTOList = new ArrayList<>();
        for (Ticket source : entityList) {
            TicketDataDTO target = entityToDataDTO(source);
            DTOList.add(target);
        }
        return DTOList;
    }

}