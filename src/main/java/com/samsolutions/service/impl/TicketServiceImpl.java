package com.samsolutions.service.impl;

import com.samsolutions.converter.DTOConverter;
import com.samsolutions.converter.TicketConverter;
import com.samsolutions.dto.TicketDTO;
import com.samsolutions.entity.Ticket;
import com.samsolutions.repository.TicketRepository;
import com.samsolutions.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("ticketRepository")
    private TicketRepository ticketRepository;

    private DTOConverter<Ticket, TicketDTO> converter = new TicketConverter();

    @Override
    public TicketDTO findTicketById(final Long id) {
        return converter.entityToDTO(ticketRepository.findOne(id));
    }

    @Override
    public void update(final TicketDTO ticketDTO) {

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
        ticketRepository.delete(id);
    }
}
