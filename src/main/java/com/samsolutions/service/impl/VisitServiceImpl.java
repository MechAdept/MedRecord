package com.samsolutions.service.impl;

import com.samsolutions.converter.DTOConverter;
import com.samsolutions.converter.VisitConverter;
import com.samsolutions.dto.VisitDTO;
import com.samsolutions.entity.Visit;
import com.samsolutions.repository.VisitRepository;
import com.samsolutions.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    private DTOConverter<Visit, VisitDTO> converter = new VisitConverter();

    @Override
    public void update(final VisitDTO visitDTO) {
    }

    @Override
    public void save(final VisitDTO visitDTO) {
        Visit visit = converter.dtoToEntity(visitDTO);
        visitRepository.save(visit);
    }

    @Override
    public List<VisitDTO> getVisits() {
        return converter.entitiesToDtoList(visitRepository.findAll());
    }

    @Override
    public void deleteVisit(final Long id) {
        visitRepository.delete(id);
    }

    @Override
    public VisitDTO findVisitById(final Long id) {
        return converter.entityToDTO(visitRepository.findOne(id));
    }
}
