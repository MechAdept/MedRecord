package com.samsolutions.service.impl;

import com.samsolutions.converter.HealthConverter;
import com.samsolutions.dto.HealthDTO;
import com.samsolutions.entity.Health;
import com.samsolutions.repository.HealthRepository;
import com.samsolutions.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implements the methods defined in the health service.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service.impl
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */


@Service("HealthService")
public class HealthServiceImpl implements HealthService {
    @Autowired
    private HealthRepository healthRepository;

    @Autowired
    private HealthConverter healthConverter;

    @Override
    public HealthDTO findHealthById(final Long id) {
        return healthConverter.entityToDTO(healthRepository.getOne(id));
    }

    @Override
    public void save(final HealthDTO healthDTO) {
        Health health = healthConverter.dtoToEntity(healthDTO);
        healthRepository.save(health);
    }

    @Override
    public List<HealthDTO> getHealths() {
        List<HealthDTO> healthDTOSet = healthConverter.entitiesToDtoList(healthRepository.findAll());
        return healthDTOSet;
    }

    @Override
    public void deleteHealth(final Long id) {
        healthRepository.deleteById(id);
    }
}
