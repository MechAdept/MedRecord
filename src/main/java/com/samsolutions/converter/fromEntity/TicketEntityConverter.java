package com.samsolutions.converter.fromEntity;

import com.samsolutions.dto.data.TicketDataDTO;
import com.samsolutions.entity.Ticket;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class TicketEntityConverter implements DataDTOConverter<Ticket, TicketDataDTO> {

    @Override
    public TicketDataDTO entityToDataDTO(Ticket entity) {
        return null;
    }

    @Override
    public Set<TicketDataDTO> entitiesToDataDtoSet(Set<Ticket> entitySet) {
        return null;
    }

    @Override
    public List<TicketDataDTO> entitiesToDataDtoList(List<Ticket> entityList) {
        return null;
    }
}
