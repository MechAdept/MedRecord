package com.samsolutions.service.impl;

import com.samsolutions.converter.VisitConverter;
import com.samsolutions.dto.VisitDTO;
import com.samsolutions.entity.Visit;
import com.samsolutions.repository.VisitRepository;
import com.samsolutions.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private VisitConverter visitConverter;

    @Override
    public void save(final VisitDTO visitDTO) {
        Visit visit = visitConverter.dtoToEntity(visitDTO);
        visitRepository.save(visit);
    }

    @Override
    public void deleteVisit(final Long id) {
        visitRepository.deleteById(id);
    }

    @Override
    public VisitDTO findVisitById(final Long id) {
        return visitConverter.entityToDTO(visitRepository.getOne(id));
    }

    @Override
    public List<VisitDTO> getPage(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Pageable pageable = getPageable(pageNo, pageSize, desc, sort);
        Page<Visit> pagedResult = visitRepository.findAll(pageable);
        if (pagedResult.hasContent()) {
            return visitConverter.entitiesToDtoList(pagedResult.getContent());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public Long getPageCount(Integer pageSize) {
        return visitRepository.count() / pageSize;
    }

    @Override
    public Long getTotalCount() {
        return visitRepository.count();
    }

    private Pageable getPageable(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        if (desc) {
            return PageRequest.of(pageNo, pageSize, Sort.by(sort).descending());
        } else {
            return PageRequest.of(pageNo, pageSize, Sort.by(sort).ascending());
        }
    }
}
