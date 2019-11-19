package com.samsolutions.service;

import com.samsolutions.dto.data.TicketDataDTO;
import com.samsolutions.dto.form.TicketFormDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Ticket service determine methods for working with ticket table.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Service
public interface TicketService extends IEntity<TicketDataDTO, TicketFormDTO> {

    void booking(Long patientId, Long scheduleId);

    TicketDataDTO current(Long PatientId, Long doctorId);

    Map<String, Object> getMapAndPageByUser(Long id, Integer pageNo, Integer pageSize, Boolean desc, String sort);

    Map<String, Object> getMapAndPageForCurrentUser(Integer pageNo, Integer pageSize, Boolean desc, String sort);
}
