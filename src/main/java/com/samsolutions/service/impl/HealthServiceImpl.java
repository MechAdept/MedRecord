package com.samsolutions.service.impl;

import com.samsolutions.converter.HealthConverter;
import com.samsolutions.dto.data.HealthDataDTO;
import com.samsolutions.dto.data.UserDataDTO;
import com.samsolutions.dto.form.HealthFormDTO;
import com.samsolutions.entity.Health;
import com.samsolutions.entity.User;
import com.samsolutions.repository.HealthRepository;
import com.samsolutions.repository.UserRepository;
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

@Transactional
public class HealthServiceImpl implements HealthService {

    @Autowired
    private HealthRepository healthRepository;

    @Autowired
    private HealthConverter healthConverter;

    @Autowired
    private UserService userService;

    @Autowired
    UserRepository userRepository;

    @Override
    public HealthDataDTO findById(final Long id) {
        HealthDataDTO healthDataDTO = healthConverter.entityToDataDto(healthRepository.findById(id).orElse(new Health()));
        UserDataDTO userDataDTO = userService.findWithRolesById(healthDataDTO.getPatient().getId());
        healthDataDTO.setPatient(userDataDTO);
        return healthConverter.entityToDataDto(healthRepository.findById(id).orElse(new Health()));
    }

    @Override
    public void create(final HealthFormDTO formDTO) {
        Health health = healthConverter.formDtoToEntity(formDTO);
        healthRepository.save(health);
    }

    @Override
    public void deleteHealthByPatientId(Long id) {
        User patient = userRepository.getOne(id);
        healthRepository.deleteHealthByPatient(patient);
    }

    @Override
    public HealthDataDTO findByPatientId(Long id) {
        try {
            User patient = userRepository.getOne(id);
            return healthConverter.entityToDataDto(healthRepository.findHealthByPatient(patient));
        } catch (NullPointerException ne) {
            return new HealthDataDTO();
        }
    }

    @Override
    public void delete(Long id) {
        healthRepository.deleteById(id);
    }
}
