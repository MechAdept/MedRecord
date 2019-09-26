package com.samsolutions.service.impl;

import com.samsolutions.converter.TicketConverterData;
import com.samsolutions.converter.UserConverterData;
import com.samsolutions.converter.VisitConverterData;
import com.samsolutions.dto.data.TicketDataDTO;
import com.samsolutions.dto.VisitDTO;
import com.samsolutions.entity.Visit;
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

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private VisitConverterData visitConverter;

    @Autowired
    private TicketConverterData ticketConverter;

    @Autowired
    UserConverterData userConverter;

    @Override
    public void save(final VisitDTO visitDTO) {
        Visit visit = visitConverter.formDtoToEntity(visitDTO);
        visitRepository.save(visit);
    }

    @Override
    public void delete(final Long id) {
        visitRepository.deleteById(id);
    }


    @Override
    public VisitDTO findById(final Long id) {
        return visitConverter.entityToDataDTO(visitRepository.getOne(id));
    }

    @Override
    public VisitDTO findByTicket(TicketDataDTO ticketDataDTO) {
        return visitConverter.entityToDataDTO(visitRepository.findVisitByTicket(ticketConverter.formDtoToEntity(ticketDataDTO)));
    }
}
