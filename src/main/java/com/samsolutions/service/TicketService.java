package com.samsolutions.service;

import com.samsolutions.entity.Role;
import com.samsolutions.entity.Ticket;
import org.springframework.stereotype.Service;

@Service
public interface TicketService {
    Ticket findTicketById(Long id);
}
