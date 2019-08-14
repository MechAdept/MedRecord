package com.samsolutions.service;

import com.samsolutions.dto.VisitDTO;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * @param ticketDTO VisitDTO with parameters to be set.
     */
    void save(VisitDTO ticketDTO);

    /**
     * Method for find visit by id.
     *
     * @param id id of desired visit.
     * @return VisitDTO.
     */
    VisitDTO findVisitById(Long id);

    /**
     * Method for delete visit by id.
     *
     * @param id id of desired visit.
     */
    void deleteVisit(Long id);

    List<VisitDTO> getPage(Integer pageNo, Integer pageSize, Boolean desc, String sort);

    Long getPageCount(Integer pageSize);

    Long getTotalCount();
}
