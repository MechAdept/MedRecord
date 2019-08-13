package com.samsolutions.service.impl;

import com.samsolutions.converter.TicketConverter;
import com.samsolutions.dto.TicketDTO;
import com.samsolutions.entity.Ticket;
import com.samsolutions.repository.TicketRepository;
import com.samsolutions.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    TicketConverter ticketConverter;

    @Override
    public TicketDTO findTicketById(final Long id) {
        return ticketConverter.entityToDTO(ticketRepository.getOne(id));
    }

    @Override
    public void save(final TicketDTO ticketDTO) {
        ticketRepository.save(ticketConverter.dtoToEntity(ticketDTO));
    }

    @Override
    public List<TicketDTO> getTickets() {
        return ticketConverter.entitiesToDtoList(ticketRepository.findAll(new Sort(Sort.Direction.ASC, "id")));
    }

    @Override
    public void deleteTicket(final Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public List<TicketDTO> getPage(Integer pageNo, Integer pageSize, Boolean idReverse) {
        Pageable pageable;
        if(idReverse){
            pageable = PageRequest.of(pageNo, pageSize, Sort.by("id").descending());
        }
        else {
            pageable = PageRequest.of(pageNo, pageSize, Sort.by("id").ascending());
        }
        Page<Ticket> pagedResult = ticketRepository.findAll(pageable);
        if (pagedResult.hasContent()) {
            return ticketConverter.entitiesToDtoList(pagedResult.getContent());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Long getPageCount(Integer pageSize) {
        return ticketRepository.count() / pageSize;
    }

    @Override
    public Long getTotalCount() {
        return ticketRepository.count();
    }
}
