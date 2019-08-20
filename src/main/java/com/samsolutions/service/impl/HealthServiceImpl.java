package com.samsolutions.service.impl;

import com.samsolutions.converter.HealthConverter;
import com.samsolutions.converter.UserConverter;
import com.samsolutions.dto.HealthDTO;
import com.samsolutions.dto.UserDTO;
import com.samsolutions.entity.Health;
import com.samsolutions.repository.HealthRepository;
import com.samsolutions.service.HealthService;
import com.samsolutions.service.UserService;
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
 * Implements the methods defined in the health service.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service.impl
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */


@Service("HealthService")
@Transactional
public class HealthServiceImpl implements HealthService {
    @Autowired
    private HealthRepository healthRepository;

    @Autowired
    private HealthConverter healthConverter;

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    @Override
    public HealthDTO findHealthById(final Long id) {
        HealthDTO healthDTO = healthConverter.entityToDTO(healthRepository.findById(id).orElse(new Health()));
        UserDTO userDTO = userService.findWithRolesById(healthDTO.getPatient().getId());
        healthDTO.setPatient(userDTO);
        return healthConverter.entityToDTO(healthRepository.findById(id).orElse(new Health()));
    }

    @Override
    public void save(final HealthDTO healthDTO) {
        Health health = healthConverter.dtoToEntity(healthDTO);
        healthRepository.save(health);
    }

    @Override
    public List<HealthDTO> getHealths() {
        return healthConverter.entitiesToDtoList(healthRepository.findAll(new Sort(Sort.Direction.ASC, "id")));
    }

    public List<HealthDTO> getPage(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Pageable pageable = getPageable(pageNo, pageSize, desc, sort);
        Page<Health> pagedResult = healthRepository.findAll(pageable);
        if (pagedResult.hasContent()) {
            return healthConverter.entitiesToDtoList(pagedResult.getContent());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public void deleteHealthByPatient(UserDTO userDTO) {
        healthRepository.deleteHealthByPatient(userConverter.dtoToEntity(userDTO));
    }

    @Override
    public Long getPageCount(Integer pageSize) {
        return healthRepository.count() / pageSize;
    }

    @Override
    public Long getTotalCount() {
        return healthRepository.count();
    } 

    @Override
    public HealthDTO findHealthByPatientId(Long id) {
        try {
            UserDTO userDTO = userService.findById(id);
            return healthConverter.entityToDTO(healthRepository.findHealthByPatient(userConverter.dtoToEntity(userDTO)));
        } catch (NullPointerException ne) {
            return new HealthDTO();
        }
    }

    @Override
    public void deleteHealth(Long id) {
        Health health = healthConverter.dtoToEntity(findHealthById(id));
        healthRepository.delete(health);
    }

    private Pageable getPageable(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        if (desc) {
            return PageRequest.of(pageNo, pageSize, Sort.by(sort).descending());
        } else {
            return PageRequest.of(pageNo, pageSize, Sort.by(sort).ascending());
        }
    }
}
