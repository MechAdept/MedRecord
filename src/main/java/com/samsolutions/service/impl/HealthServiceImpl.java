package com.samsolutions.service.impl;

import com.samsolutions.converter.DTOConverter;
import com.samsolutions.converter.HealthConverter;
import com.samsolutions.converter.RoleConverter;
import com.samsolutions.dto.HealthDTO;
import com.samsolutions.dto.RoleDTO;
import com.samsolutions.entity.Health;
import com.samsolutions.entity.Role;
import com.samsolutions.repository.HealthRepository;
import com.samsolutions.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("HealthService")
public class HealthServiceImpl implements HealthService {
    @Autowired
    @Qualifier("healthRepository")
    private HealthRepository healthRepository;

    private DTOConverter<Health, HealthDTO> converter= new HealthConverter();

    @Override
    public HealthDTO findHealthById(Long id) {
        return converter.EntityToDTO(healthRepository.findOne(id));
    }

    @Override
    public void update(HealthDTO healthDTO) {

    }

    @Override
    public void save(HealthDTO healthDTO) {
        healthRepository.save(converter.DTOToEntity(healthDTO));
    }

    @Override
    public List<HealthDTO> gethealths() {
        return converter.EListToDTO(healthRepository.findAll());
    }

    @Override
    public void deleteHealth(Long id) {
        healthRepository.delete(id);
    }
}
