package com.samsolutions.converter.toEntity;

import com.samsolutions.dto.form.TicketFormDTO;
import com.samsolutions.entity.Ticket;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class TicketFormConverter implements FormDTOConverter<Ticket, TicketFormDTO> {

    @Override
    public Ticket formDtoToEntity(TicketFormDTO formDto) {
        return null;
    }

    @Override
    public Set<Ticket> formDtoSetToEntities(Set<TicketFormDTO> formDtoSet) {
        return null;
    }
}
