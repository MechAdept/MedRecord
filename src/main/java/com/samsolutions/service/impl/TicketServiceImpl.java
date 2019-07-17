package com.samsolutions.service.impl;

import com.samsolutions.converter.DTOConverter;
import com.samsolutions.converter.TicketConverter;
import com.samsolutions.dto.TicketDTO;
import com.samsolutions.entity.Ticket;
import com.samsolutions.repository.RoleRepository;
import com.samsolutions.repository.TicketRepository;
import com.samsolutions.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TicketService")
public class TicketServiceImpl implements TicketService{
    @Autowired
    @Qualifier("ticketRepository")
    private TicketRepository ticketRepository;

    private DTOConverter<Ticket, TicketDTO> converter= new TicketConverter();

    @Override
    public TicketDTO findTicketById(Long id) {
        return converter.EntityToDTO(ticketRepository.findOne(id));
    }

    @Override
    public void update(TicketDTO ticketDTO) {

    }

    @Override
    public void save(TicketDTO ticketDTO) {
        ticketRepository.save(converter.DTOToEntity(ticketDTO));
    }

    @Override
    public List<TicketDTO> getTickets() {
        List<Ticket> userList= ticketRepository.findAll();
        System.out.println("some test");
        return converter.EListToDTO(ticketRepository.findAll());
    }

    @Override
    public void deleteTicket(Long id) {
        ticketRepository.delete(id);
    }
}
