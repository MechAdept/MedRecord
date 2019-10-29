package com.samsolutions.service.impl;

import com.samsolutions.converter.TicketConverter;
import com.samsolutions.converter.UserConverter;
import com.samsolutions.dto.data.TicketDataDTO;
import com.samsolutions.dto.form.TicketFormDTO;
import com.samsolutions.entity.Schedule;
import com.samsolutions.entity.Ticket;
import com.samsolutions.entity.User;
import com.samsolutions.repository.ScheduleRepository;
import com.samsolutions.repository.TicketRepository;
import com.samsolutions.repository.UserRepository;
import com.samsolutions.service.TicketService;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implements the methods defined in the ticket service.
 *
 * @author Vladislav Brazovskij <u.brazouski@sam-solutions.com>
 * @package com.samsolutions.service.impl
 * @link http ://sam-solutions.com/
 * @copyright 2019 SaM
 */

@Transactional
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    TicketConverter ticketConverter;

    @Autowired
    UserConverter userConverter;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ScheduleRepository scheduleRepository;

    @Override
    @Transactional(readOnly = true)
    public TicketDataDTO findById(final Long id) {
        return ticketConverter.entityToDataDto(ticketRepository.findById(id).orElse(new Ticket()));
    }

    @Override
    public void save(final TicketFormDTO formDTO) {
        ticketRepository.save(ticketConverter.formDtoToEntity(formDTO));
    }

    @Override
    public void delete(final Long id) {
        ticketRepository.deleteById(id);
    }

    @Override
    public void booking(Long patientId, Long scheduleId) {
        Ticket ticket = new Ticket();
        Schedule schedule = scheduleRepository.getOne(scheduleId);
        ticket.setDoctor(userRepository.getOne(schedule.getDoctor().getId()));
        ticket.setPatient(userRepository.getOne(patientId));
        ticket.setDatetime(schedule.getDatetime());
        ticketRepository.save(ticket);
    }

    public TicketDataDTO current(Long patientId, Long doctorId) {
        return ticketConverter.entityToDataDto(ticketRepository.findNotClousedCoupon(userRepository.getOne(patientId), userRepository.getOne(doctorId)));
    }

    @Override
    public Map<String, Object> getMapAndPage(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Map<String, Object> map = new HashMap<>();
        map.put("DTOList", getPage(pageNo, pageSize, desc, sort));
        map.put("pageNo", pageNo);
        map.put("pageSize", pageSize);
        map.put("desc", desc);
        map.put("sort", sort);
        map.put("pageCount", getPageCount(pageSize));
        map.put("elementsCount", getTotalCount());
        return map;
    }

    @Override
    public Map<String, Object> getMapAndPageByUser(Long id, Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        User user = userRepository.getOne(id);
        Map<String, Object> map = new HashMap<>();
        map.put("DTOList", getPageByUser(user, pageNo, pageSize, desc, sort));
        map.put("pageNo", pageNo);
        map.put("pageSize", pageSize);
        map.put("desc", desc);
        map.put("sort", sort);
        map.put("pageCount", getPageCountByUser(pageSize, user));
        map.put("elementsCount", getTotalCountByUser(user));
        map.put("userDTO", userConverter.entityToDataDto(user));
        return map;
    }

    private Pageable getPageable(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Pageable pageable;
        if (desc) {
            pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(sort).descending());
        } else {
            pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(sort).ascending());
        }
        return pageable;
    }

    private List<TicketDataDTO> getPage(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Pageable pageable = getPageable(pageNo, pageSize, desc, sort);
        Page<Ticket> pagedResult = ticketRepository.findAll(pageable);
        if (pagedResult.hasContent()) {
            return ticketConverter.entitiesToDataDtoList(pagedResult.getContent());
        } else {
            return new ArrayList<>();
        }
    }

    private List<TicketDataDTO> getPageByUser(User user, Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Pageable pageable = getPageable(pageNo, pageSize, desc, sort);
        Page<Ticket> pagedResult = ticketRepository.findByDoctorOrPatientEquals(user, user, pageable);
        if (pagedResult.hasContent()) {
            return ticketConverter.entitiesToDataDtoList(pagedResult.getContent());
        } else {
            return new ArrayList<>();
        }
    }

    private Long getPageCount(Integer pageSize) {
        return ticketRepository.count() / pageSize;
    }

    private Long getTotalCount() {
        return ticketRepository.count();
    }

    private Long getPageCountByUser(Integer pageSize, User user) {
        return getTotalCountByUser(user) / pageSize;
    }

    private Long getTotalCountByUser(User user) {
        return ticketRepository.countAllByDoctorOrPatient(user, user);
    }
}
