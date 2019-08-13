package com.samsolutions.service.impl;

import com.samsolutions.converter.HealthConverter;
import com.samsolutions.dto.HealthDTO;
import com.samsolutions.entity.Health;
import com.samsolutions.repository.HealthRepository;
import com.samsolutions.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        return healthConverter.entitiesToDtoList(healthRepository.findAll(new Sort(Sort.Direction.ASC,"id")));
    }

    public List<HealthDTO> getPage(Integer pageNo, Integer pageSize, Boolean idReverse) {
        Pageable pageable;
        if (idReverse) {
            pageable = PageRequest.of(pageNo, pageSize, Sort.by("id").descending());
        } else {
            pageable = PageRequest.of(pageNo, pageSize, Sort.by("id").ascending());
        }
        Page<Health> pagedResult = healthRepository.findAll(pageable);
        if (pagedResult.hasContent()) {
            return healthConverter.entitiesToDtoList(pagedResult.getContent());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public void deleteHealth(final Long id) {
        healthRepository.deleteById(id);
    }

    @Override
    public Long getPageCount(Integer pageSize) {
        return healthRepository.count() / pageSize;
    }

    @Override
    public Long getTotalCount() {
        return healthRepository.count();
    }
}
