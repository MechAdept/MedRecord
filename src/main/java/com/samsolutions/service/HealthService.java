package com.samsolutions.service;

import com.samsolutions.dto.data.HealthDataDTO;
import com.samsolutions.dto.form.HealthFormDTO;
import org.springframework.stereotype.Service;

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
public interface HealthService extends IEntity<HealthDataDTO, HealthFormDTO> {

    void save(HealthFormDTO formDTO);

    void deleteHealthByPatientId(Long id);

    HealthDataDTO findByPatientId(Long id);

    HealthDataDTO getCurrent();
}
