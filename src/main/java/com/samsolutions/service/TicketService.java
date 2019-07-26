package com.samsolutions.service;

import com.samsolutions.dto.TicketDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Ticket service determine methods for working with ticket table.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Service
public interface TicketService {
    /**
     * Method for create ticket.
     *
     * @param ticketDTO TicketDTO with parameters to be set.
     */
    void save(TicketDTO ticketDTO);

    /**
     * Method for getting ticket from table.
     *
     * @return List<TicketDTO>.
     */
    List<TicketDTO> getTickets();

    /**
     * Method for find ticket by id.
     *
     * @param id id of desired ticket.
     * @return TicketDTO.
     */
    TicketDTO findTicketById(Long id);

    /**
     * Method for update ticket.
     *
     * @param ticketDTO TicketDTO with parameters to be set.
     */
    void update(TicketDTO ticketDTO);

    /**
     * Method for delete ticket by id.
     *
     * @param id id of desired ticket.
     */
    void deleteTicket(Long id);
}
