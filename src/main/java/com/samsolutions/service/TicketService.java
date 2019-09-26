package com.samsolutions.service;

import com.samsolutions.dto.data.TicketDataDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

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
     * @param ticketDataDTO TicketDTO with parameters to be set.
     */
    void save(TicketDataDTO ticketDataDTO);

    /**
     * Method for find ticket by id.
     *
     * @param id id of desired ticket.
     * @return TicketDTO.
     */
    TicketDataDTO findTicketById(Long id);

    /**
     * Method for delete ticket by id.
     *
     * @param id id of desired ticket.
     */
    void deleteTicket(Long id);

    Map<String,Object> getMapAndPage(Integer pageNo, Integer pageSize, Boolean desc, String sort);

    Map<String,Object> getMapAndPageByUser(Long id, Integer pageNo, Integer pageSize, Boolean desc, String sort);
}
