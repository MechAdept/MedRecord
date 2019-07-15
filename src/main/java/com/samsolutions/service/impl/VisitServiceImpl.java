package com.samsolutions.service.impl;

import com.samsolutions.converter.DTOConverter;
import com.samsolutions.converter.VisitConverter;
import com.samsolutions.dto.VisitDTO;
import com.samsolutions.entity.Visit;
import com.samsolutions.repository.VisitRepository;
import com.samsolutions.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

public class VisitServiceImpl implements VisitService {
    @Autowired
    private VisitRepository visitRepository;

    DTOConverter<Visit, VisitDTO> converter = new VisitConverter();

    @Override
    public void update(VisitDTO visitDTO) {
    }

    @Override
    public List<VisitDTO> getVisits() {
        return converter.EListToDTO(visitRepository.findAll());
    }

    @Override
    public void save(VisitDTO visitDTO) {
        Visit visit = converter.DTOToEntity(visitDTO);
        visitRepository.save(visit);
    }

    @Override
    public List<VisitDTO> getvisits() {
        return converter.EListToDTO(visitRepository.findAll());
    }

    @Override
    public void deleteVisit(Long id) {
        visitRepository.delete(id);
    }

    @Override
    public VisitDTO findVisitById(Long id) {
        return converter.EntityToDTO(visitRepository.findOne(id));
    }
}
