package com.samsolutions.service.impl;

import com.samsolutions.converter.DTOConverter;
import com.samsolutions.converter.HealthConverter;
import com.samsolutions.dto.HealthDTO;
import com.samsolutions.entity.Health;
import com.samsolutions.repository.HealthRepository;
import com.samsolutions.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    @Qualifier("healthRepository")
    private HealthRepository healthRepository;

    private DTOConverter<Health, HealthDTO> converter = new HealthConverter();

    @Override
    public HealthDTO findHealthById(final Long id) {
        return converter.entityToDTO(healthRepository.findOne(id));
    }

    @Override
    public void update(final HealthDTO healthDTO) {
    }

    @Override
    public void save(final HealthDTO healthDTO) {
        healthRepository.save(converter.dtoToEntity(healthDTO));
    }

    @Override
    public List<HealthDTO> getHealths() {
        return converter.entitiesToDtoList(healthRepository.findAll());
    }

    @Override
    public void deleteHealth(final Long id) {
        healthRepository.delete(id);
    }
}
