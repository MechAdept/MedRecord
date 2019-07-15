package com.samsolutions.service;

import com.samsolutions.dto.TicketDTO;
import com.samsolutions.entity.Role;
import com.samsolutions.entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TicketService {
    TicketDTO findTicketById(Long id);

    void update(TicketDTO ticketDTO);

    void save(TicketDTO ticketDTO);

    List<TicketDTO> gettickets();

    void deleteTicket(Long id);
}
