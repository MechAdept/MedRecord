package com.samsolutions.converter;

import com.samsolutions.dto.TicketDTO;
import com.samsolutions.dto.UserDTO;
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
public class TicketConverter implements DTOConverter<Ticket, TicketDTO> {

    @Autowired
    private DTOConverter<User, UserDTO> userConverter;

    @Override
    public TicketDTO entityToDTO(final Ticket source) {
        TicketDTO target = new TicketDTO();
        target.setId(source.getId());
        target.setDatetime(source.getDatetime());
        target.setAttendance(source.getAttendance());
        return target;
    }

    @Override
    public Ticket dtoToEntity(final TicketDTO source) {
        Ticket target = new Ticket();
        target.setId(source.getId());
        target.setAttendance(source.getAttendance());
        target.setDatetime(source.getDatetime());
        target.setDoctor(userConverter.dtoToEntity(source.getDoctor()));
        target.setPatient(userConverter.dtoToEntity(source.getPatient()));
        return target;
    }

    @Override
    public Set<TicketDTO> entitiesToDtoSet(final Set<Ticket> entitySet) {
        Set<TicketDTO> DTOSet = new HashSet<>();
        for (Ticket source : entitySet) {
            TicketDTO target = entityToDTO(source);
            DTOSet.add(target);
        }
        return DTOSet;
    }

    @Override
    public Set<Ticket> dtoSetToEntities(final Set<TicketDTO> ticketDTOSet) {
        Set<Ticket> entitySet = new HashSet<>();
        for (TicketDTO source : ticketDTOSet) {
            Ticket target = dtoToEntity(source);
            entitySet.add(target);
        }
        return entitySet;
    }

    @Override
    public List<TicketDTO> entitiesToDtoList(List<Ticket> entityList) {
        List<TicketDTO> DTOList = new ArrayList<>();
        for (Ticket source : entityList) {
            TicketDTO target = entityToDTO(source);
            DTOList.add(target);
        }
        return DTOList;
    }

}