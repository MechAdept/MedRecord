package com.samsolutions.service;

import com.samsolutions.dto.data.TicketDataDTO;
import com.samsolutions.dto.VisitDTO;
import com.samsolutions.dto.data.VisitDataDTO;
import com.samsolutions.dto.form.VisitFormDTO;
import org.springframework.stereotype.Service;

/**
 * Visit service determine methods for working with visit table.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Service(value = "visitService")
public interface VisitService {
    /**
     * Method for create visit.
     *
     * @param formDTO VisitFormDTO with parameters to be set.
     */
    void save(VisitFormDTO formDTO);

    /**
     * Method for find visit by id.
     *
     * @param id id of desired visit.
     * @return VisitDTO.
     */
    VisitDataDTO findById(Long id);

    /**
     * Method for delete visit by id.
     *
     * @param id id of desired visit.
     */
    void delete(Long id);

    VisitDataDTO findByTicket(TicketDataDTO dataDTO);
}
