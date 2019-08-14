package com.samsolutions.service.impl;

import com.samsolutions.converter.TicketConverter;
import com.samsolutions.converter.UserConverter;
import com.samsolutions.dto.TicketDTO;
import com.samsolutions.dto.UserDTO;
import com.samsolutions.entity.Ticket;
import com.samsolutions.entity.User;
import com.samsolutions.repository.TicketRepository;
import com.samsolutions.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Transactional
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    TicketConverter ticketConverter;

    @Autowired
    UserConverter userConverter;

    @Override
    @Transactional(readOnly = true)
    public TicketDTO findTicketById(final Long id) {
        return ticketConverter.entityToDTO(ticketRepository.findById(id).orElse(new Ticket()));
    }

    @Override
    public void save(final TicketDTO ticketDTO) {
        ticketRepository.save(ticketConverter.dtoToEntity(ticketDTO));
    }

    @Override
    public void deleteTicket(final Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDTO> getPage(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Pageable pageable = getPageable(pageNo, pageSize, desc, sort);
        Page<Ticket> pagedResult = ticketRepository.findAll(pageable);
        if (pagedResult.hasContent()) {
            return ticketConverter.entitiesToDtoList(pagedResult.getContent());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Long getPageCount(Integer pageSize) {
        return ticketRepository.count() / pageSize;
    }

    @Override
    @Transactional(readOnly = true)
    public Long getTotalCount() {
        return ticketRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Long getPageCountByUser(Integer pageSize, UserDTO userDTO) {
        return getTotalCountByUser(userDTO) / pageSize;
    }

    @Override
    public Long getTotalCountByUser(UserDTO userDTO) {
        return ticketRepository.countAllByDoctorOrPatient(userConverter.dtoToEntity(userDTO), userConverter.dtoToEntity(userDTO));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TicketDTO> getPageByUser(UserDTO userDTO, Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Pageable pageable = getPageable(pageNo, pageSize, desc, sort);
        User user = userConverter.dtoToEntity(userDTO);
        Page<Ticket> pagedResult = ticketRepository.findByDoctorOrPatientEquals(user, user, pageable);
        if (pagedResult.hasContent()) {
            return ticketConverter.entitiesToDtoList(pagedResult.getContent());
        } else {
            return new ArrayList<>();
        }
    }

    private Pageable getPageable(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Pageable pageable;
        if (desc) {
            pageable = PageRequest.of(pageNo, pageSize, Sort.by(sort).descending());
        } else {
            pageable = PageRequest.of(pageNo, pageSize, Sort.by(sort).ascending());
        }
        return pageable;
    }
}
