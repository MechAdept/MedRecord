package com.samsolutions.service.impl;

import com.samsolutions.converter.TicketConverter;
import com.samsolutions.converter.UserConverter;
import com.samsolutions.converter.VisitConverter;
import com.samsolutions.dto.data.VisitDataDTO;
import com.samsolutions.dto.form.TicketFormDTO;
import com.samsolutions.dto.form.VisitFormDTO;
import com.samsolutions.entity.Visit;
import com.samsolutions.repository.TicketRepository;
import com.samsolutions.repository.VisitRepository;
import com.samsolutions.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implements the methods defined in the visit service.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service.impl
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private VisitConverter visitConverter;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    UserConverter userConverter;

    @Override
    public void save(final VisitFormDTO source) {
        Visit target = visitConverter.formDtoToEntity(source);
        visitRepository.save(target);
    }

    @Override
    public void delete(final Long id) {
        visitRepository.deleteById(id);
    }


    @Override
    public VisitDataDTO findById(final Long id) {
        return visitConverter.entityToDataDto(visitRepository.getOne(id));
    }

    @Override
    public VisitDataDTO findByTicketId(Long id) {
        return visitConverter.entityToDataDto(visitRepository.findVisitByTicket(ticketRepository.getOne(id)));
    }
}
