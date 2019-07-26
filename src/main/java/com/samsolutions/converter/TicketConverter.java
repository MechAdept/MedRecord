package com.samsolutions.converter;

import com.samsolutions.dto.TicketDTO;
import com.samsolutions.dto.UserDTO;
import com.samsolutions.entity.Ticket;
import com.samsolutions.entity.User;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter for Ticket.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.converter
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

public class TicketConverter implements DTOConverter<Ticket, TicketDTO> {

    private DTOConverter<User, UserDTO> userConverter = new UserConverter();

    @Override
    public TicketDTO entityToDTO(final Ticket ticket) {
        TicketDTO ticketDTO = new TicketDTO();
        BeanUtils.copyProperties(ticket, ticketDTO);
        return ticketDTO;
    }

    @Override
    public Ticket dtoToEntity(final TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(ticketDTO, ticket);
        return ticket;
    }

    @Override
    public List<TicketDTO> entitiesToDtoList(final List<Ticket> entityList) {
        List<TicketDTO> ticketDTOList = new ArrayList<>();
        for (Ticket source : entityList) {
            TicketDTO target = new TicketDTO();
            BeanUtils.copyProperties(source, target);
            target.setPatient(userConverter.entityToDTO(source.getPatient()));
            target.setDoctor(userConverter.entityToDTO(source.getDoctor()));
            ticketDTOList.add(target);
        }
        return ticketDTOList;
    }

    @Override
    public List<Ticket> dtoListToEntities(final List<TicketDTO> ticketDTOList) {
        List<Ticket> ticketList = new ArrayList<>();
        for (TicketDTO source : ticketDTOList) {
            Ticket target = new Ticket();
            BeanUtils.copyProperties(source, target);
            ticketList.add(target);
        }
        return ticketList;
    }

//    @Override
//    public String DTOToJSON(TicketDTO ticketDTO) {
//        String json = "";
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            json = mapper.writeValueAsString(ticketDTO);
//        } catch (JsonProcessingException e) {
//            System.out.println("Не удалось конвертировать в JSON"); //TODO: Add logger
//        }
//        return json;
//    }
//
//    @Override
//    public TicketDTO JSONToDTO(String json) {
//        ObjectMapper mapper = new ObjectMapper();
//        TicketDTO ticketDTO = null;
//        try {
//            ticketDTO = mapper.readValue(json, TicketDTO.class);
//        } catch (IOException e) {
//            System.out.println("Не удалось конвертировать в DTO"); //TODO: Add logger
//        }
//        return ticketDTO;
//    }
}