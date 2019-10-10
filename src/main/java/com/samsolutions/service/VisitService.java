package com.samsolutions.service;

import com.samsolutions.dto.data.VisitDataDTO;
import com.samsolutions.dto.form.TicketFormDTO;
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
public interface VisitService extends IEntity<VisitDataDTO, VisitFormDTO> {

    VisitDataDTO findByTicketId(Long id);
}
