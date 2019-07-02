package com.samsolutions.service;

import com.samsolutions.entity.Health;
import org.springframework.stereotype.Service;

@Service
public interface HealthService {
    Health findHealthById(Long id);
}
