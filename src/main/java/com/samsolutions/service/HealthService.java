package com.samsolutions.service;

import com.samsolutions.dto.HealthDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Health service determine methods for working with health table.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Service
@Transactional
public interface HealthService {
    /**
     * Method for create health.
     *
     * @param healthDTO HealthDTO with parameters to be set.
     */
    void save(HealthDTO healthDTO);

    /**
     * Method for find health by id.
     *
     * @param id id of desired health.
     * @return HealthDTO.
     */
    @Transactional(readOnly = true)
    HealthDTO findHealthById(Long id);

    /**
     * Method for getting healths from table.
     *
     * @return List<HealthDTO>.
     */
    @Transactional(readOnly = true)
    List<HealthDTO> getHealths();

    /**
     * Method for delete health by id.
     *
     * @param id id of desired health.
     */
    void deleteHealth(Long id);
}
