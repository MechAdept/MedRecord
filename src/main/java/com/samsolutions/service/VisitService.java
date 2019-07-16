package com.samsolutions.service;

import com.samsolutions.dto.VisitDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "visitService")
public interface VisitService {
    VisitDTO findVisitById(Long id);

    void update(VisitDTO ticketDTO);

    void save(VisitDTO ticketDTO);

    List<VisitDTO> getvisits();

    void deleteVisit(Long id);
}
