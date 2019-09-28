package com.samsolutions.service;

import com.samsolutions.dto.HealthDTO;
import com.samsolutions.dto.data.HealthDataDTO;
import com.samsolutions.dto.data.UserDTO;
import com.samsolutions.dto.form.HealthFormDTO;
import com.samsolutions.dto.form.UserFormDTO;
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
public interface HealthService {
    /**
     * Method for create health.
     *
     * @param formDTO HealthDTO with parameters to be set.
     */
    void save(HealthFormDTO formDTO);

    /**
     * Method for find health by id.
     *
     * @param id id of desired health.
     * @return HealthDTO.
     */
    HealthDataDTO findHealthById(Long id);

    /**
     * Method for getting healths from table.
     *
     * @return List<HealthDTO>.
     */
    List<HealthDataDTO> getHealths();

    List<HealthDataDTO> getPage(Integer pageNo, Integer pageSize, Boolean desc, String sort);

    void deleteHealthByPatient(Long id);

    Long getPageCount(Integer pageSize);

    Long getTotalCount();

    HealthDataDTO findHealthByPatientId(Long id);

    void deleteHealth(Long id);
}
