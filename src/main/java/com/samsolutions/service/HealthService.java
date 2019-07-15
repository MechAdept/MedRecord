package com.samsolutions.service;

import com.samsolutions.dto.HealthDTO;
import com.samsolutions.dto.RoleDTO;
import com.samsolutions.entity.Health;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HealthService {
    HealthDTO findHealthById(Long id);

    void update(HealthDTO healthDTO);

    void save(HealthDTO healthDTO);

    List<HealthDTO> gethealths();

    void deleteHealth(Long id);
}
