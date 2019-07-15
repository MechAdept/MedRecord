package com.samsolutions.converter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.samsolutions.dto.TicketDTO;
import com.samsolutions.entity.Ticket;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TicketConverter implements DTOConverter<Ticket, TicketDTO> {

    @Override
    public TicketDTO EntityToDTO(Ticket ticket) {
        TicketDTO ticketDTO = new TicketDTO();
        BeanUtils.copyProperties(ticket, ticketDTO);
        return ticketDTO;
    }

    @Override
    public Ticket DTOToEntity(TicketDTO ticketDTO) {
        Ticket ticket = new Ticket();
        BeanUtils.copyProperties(ticketDTO, ticket);
        return ticket;
    }

    @Override
    public List<TicketDTO> EListToDTO(List<Ticket> entityList) {
        List<TicketDTO> ticketDTOList = new ArrayList<>();
        for (Ticket source : entityList) {
            TicketDTO target = new TicketDTO();
            BeanUtils.copyProperties(source, target);
            ticketDTOList.add(target);
        }
        return ticketDTOList;
    }

    @Override
    public List<Ticket> DTOListToEntity(List<TicketDTO> ticketDTOList) {
        List<Ticket> ticketList = new ArrayList<>();
        for (TicketDTO source : ticketDTOList) {
            Ticket target = new Ticket();
            BeanUtils.copyProperties(source, target);
            ticketList.add(target);
        }
        return ticketList;
    }

    @Override
    public String DTOToJSON(TicketDTO ticketDTO) {
        String json = "";
        ObjectMapper mapper = new ObjectMapper();
        try {
            json = mapper.writeValueAsString(ticketDTO);
        } catch (JsonProcessingException e) {
            System.out.println("Не удалось конвертировать в JSON"); //ДОБАВИТЬ ЛОГГЕР
        }
        return json;
    }

    @Override
    public TicketDTO JSONToDTO(String json) {
        ObjectMapper mapper = new ObjectMapper();
        TicketDTO ticketDTO = null;
        try {
            ticketDTO = mapper.readValue(json, TicketDTO.class);
        } catch (IOException e) {
            System.out.println("Не удалось конвертировать в DTO"); //ДОБАВИТЬ ЛОГГЕР
        }
        return ticketDTO;
    }
}

