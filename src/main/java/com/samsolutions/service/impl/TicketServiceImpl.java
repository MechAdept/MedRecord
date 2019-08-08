package com.samsolutions.service.impl;

import com.samsolutions.converter.TicketConverter;
import com.samsolutions.dto.TicketDTO;
import com.samsolutions.repository.TicketRepository;
import com.samsolutions.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements the methods defined in the ticket service.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service.impl
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Service("TicketService")
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    TicketConverter converter;

    @Override
    public TicketDTO findTicketById(final Long id) {
        return converter.entityToDTO(ticketRepository.getOne(id));
    }

    @Override
    public void save(final TicketDTO ticketDTO) {
        ticketRepository.save(converter.dtoToEntity(ticketDTO));
    }

    @Override
    public List<TicketDTO> getTickets() {
        return converter.entitiesToDtoList(ticketRepository.findAll());
    }

    @Override
    public void deleteTicket(final Long id) {
        ticketRepository.deleteById(id);
    }
}
