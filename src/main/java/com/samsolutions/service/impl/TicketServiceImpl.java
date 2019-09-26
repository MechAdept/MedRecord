package com.samsolutions.service.impl;

import com.samsolutions.converter.TicketConverterData;
import com.samsolutions.converter.UserConverterData;
import com.samsolutions.dto.data.TicketDataDTO;
import com.samsolutions.dto.data.UserDTO;
import com.samsolutions.entity.Ticket;
import com.samsolutions.entity.User;
import com.samsolutions.repository.TicketRepository;
import com.samsolutions.service.TicketService;
import com.samsolutions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

@Service("TicketService")
@Transactional
public class TicketServiceImpl implements TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    TicketConverterData ticketConverter;

    @Autowired
    UserConverterData userConverter;

    @Autowired
    UserService userService;

    @Override
    @Transactional(readOnly = true)
    public TicketDataDTO findTicketById(final Long id) {
        return ticketConverter.entityToDataDTO(ticketRepository.findById(id).orElse(new Ticket()));
    }

    @Override
    public void save(final TicketDataDTO ticketDataDTO) {
        ticketRepository.save(ticketConverter.formDtoToEntity(ticketDataDTO));
    }

    @Override
    public void deleteTicket(final Long id) {
        ticketRepository.deleteById(id);
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
        UserDTO userDTO = userService.findById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("DTOList", getPageByUser(userDTO, pageNo, pageSize, desc, sort));
        map.put("pageNo", pageNo);
        map.put("pageSize", pageSize);
        map.put("desc", desc);
        map.put("sort", sort);
        map.put("pageCount", getPageCountByUser(pageSize, userDTO));
        map.put("elementsCount", getTotalCountByUser(userDTO));
        map.put("userDTO", userDTO);
        return map;
    }

    private Pageable getPageable(Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Pageable pageable;
        if (desc) {
            pageable = PageRequest.of(pageNo-1, pageSize, Sort.by(sort).descending());
        } else {
            pageable = PageRequest.of(pageNo-1, pageSize, Sort.by(sort).ascending());
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

    private List<TicketDataDTO> getPageByUser(UserDTO userDTO, Integer pageNo, Integer pageSize, Boolean desc, String sort) {
        Pageable pageable = getPageable(pageNo, pageSize, desc, sort);
        User user = userConverter.formDtoToEntity(userDTO);
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

    private Long getPageCountByUser(Integer pageSize, UserDTO userDTO) {
        return getTotalCountByUser(userDTO) / pageSize;
    }

    private Long getTotalCountByUser(UserDTO userDTO) {
        return ticketRepository.countAllByDoctorOrPatient(userConverter.formDtoToEntity(userDTO), userConverter.formDtoToEntity(userDTO));
    }
}
