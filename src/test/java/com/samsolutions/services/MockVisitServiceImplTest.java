package com.samsolutions.services;

import com.samsolutions.converter.VisitConverter;
import com.samsolutions.dto.form.VisitFormDTO;
import com.samsolutions.entity.Ticket;
import com.samsolutions.entity.Visit;
import com.samsolutions.repository.TicketRepository;
import com.samsolutions.repository.VisitRepository;
import com.samsolutions.service.impl.VisitServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class VisitServiceImplTestMockito extends Assert {

    @InjectMocks
    private VisitServiceImpl visitServiceImpl;

    @Mock
    private VisitRepository visitRepository;

    @Mock
    private TicketRepository ticketRepository;

    @Mock
    private VisitConverter visitConverter;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveTest() {
        //setUp
        VisitFormDTO visitFormDTO = new VisitFormDTO();
        visitFormDTO.setTicketId(1L);

        //when
        when(visitConverter.formDtoToEntity(visitFormDTO)).thenReturn(new Visit());
        when(ticketRepository.getOne(1L)).thenReturn(new Ticket());

        //test
        visitServiceImpl.save(visitFormDTO);
        verify(ticketRepository, times(1)).save(Mockito.any());
        verify(visitRepository, times(1)).save(Mockito.any());
    }

    @Test
    public void deleteTest() {
        //when
        doNothing().when(visitRepository).deleteById(Mockito.anyLong());

        //test
        visitServiceImpl.delete(1L);
        verify(visitRepository, times(1)).deleteById(Mockito.anyLong());
    }

    @Test
    public void findByIdTest() {
        visitServiceImpl.findById(1L);
        verify(visitRepository, times(1)).getOne(Mockito.anyLong());
        verify(visitConverter, times(1)).entityToDataDto(Mockito.any());
    }

    @Test
    public void findByTicketIdTest() {
        visitServiceImpl.findByTicketId(1L);
        verify(ticketRepository, times(1)).getOne(Mockito.anyLong());
        verify(visitRepository, times(1)).findVisitByTicket(Mockito.any());
        verify(visitConverter, times(1)).entityToDataDto(Mockito.any());
    }

}
