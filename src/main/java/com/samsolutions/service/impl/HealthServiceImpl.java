package com.samsolutions.service.impl;

import com.samsolutions.entity.Health;
import com.samsolutions.repository.HealthRepository;
import com.samsolutions.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("HealthService")
public class HealthServiceImpl implements HealthService {
    @Autowired
    @Qualifier("healthRepository")
    private HealthRepository healthRepository;
    @Override
    public Health findHealthById(Long id) {
        return healthRepository.findOne(id);
    }
}
