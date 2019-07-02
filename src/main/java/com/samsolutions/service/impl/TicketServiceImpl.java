package com.samsolutions.service.impl;

import com.samsolutions.entity.Ticket;
import com.samsolutions.repository.RoleRepository;
import com.samsolutions.repository.TicketRepository;
import com.samsolutions.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("TicketService")
public class TicketServiceImpl implements TicketService{
    @Autowired
    @Qualifier("ticketRepository")
    private TicketRepository ticketRepository;

    @Override
    public Ticket findTicketById(Long id) {
        return ticketRepository.findOne(id);
    }
}
