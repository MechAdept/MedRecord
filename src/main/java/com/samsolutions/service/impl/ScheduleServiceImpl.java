package com.samsolutions.service.impl;

import com.samsolutions.converter.ScheduleConverter;
import com.samsolutions.dto.data.ScheduleDataDTO;
import com.samsolutions.dto.form.UserFormDTO;
import com.samsolutions.entity.Schedule;
import com.samsolutions.entity.Ticket;
import com.samsolutions.entity.User;
import com.samsolutions.repository.RoleRepository;
import com.samsolutions.repository.ScheduleRepository;
import com.samsolutions.repository.TicketRepository;
import com.samsolutions.repository.UserRepository;
import com.samsolutions.roles.Roles;
import com.samsolutions.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

@Transactional
public class ScheduleServiceImpl implements ScheduleService {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    ScheduleConverter scheduleConverter;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<ScheduleDataDTO> getDayByDateAndId(String date, Long id) {
        User user = userRepository.getOne(id);

        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("yyyy-MM-dd")
                .parseDefaulting(ChronoField.HOUR_OF_DAY, 0)
                .parseDefaulting(ChronoField.MINUTE_OF_HOUR, 0)
                .parseDefaulting(ChronoField.SECOND_OF_MINUTE, 0)
                .toFormatter();

        LocalDateTime from = LocalDateTime.parse(date, formatter);
        List<Schedule> list = scheduleRepository.getDayByDoctorAndDates(user, from, from.plusDays(1));
        return scheduleConverter.entitiesToDataDtoList(list);
    }

    @Override
    public Boolean booking(Long patientId, Long scheduleId) {
        Schedule schedule = scheduleRepository.getOne(scheduleId);
        User patient = userRepository.getOne(patientId);
        User doctor = schedule.getDoctor();
        if (ticketRepository.findByDoctorIsAndPatientIsAndAttendanceIsNull(doctor, patient) != null) {
            return false;
        }
        Ticket ticket = new Ticket();
        ticket.setPatient(patient);
        ticket.setDoctor(doctor);
        ticket.setDatetime(schedule.getDatetime());
        schedule.setTicket(ticket);
        schedule.setAvailable(false);
        scheduleRepository.save(schedule);
        return true;
    }

    @Override
    public List<ScheduleDataDTO> getDayBySchedule(Long scheduleId) {
        Schedule schedule = scheduleRepository.getOne(scheduleId);
        LocalDateTime from = schedule.getDatetime().with(LocalTime.of(0, 0, 0));
        List<Schedule> list = scheduleRepository.getDayByDoctorAndDates(schedule.getDoctor(), from, from.plusDays(1));
        return scheduleConverter.entitiesToDataDtoList(list);
    }

    @Override
    public void fillMonth(UserFormDTO userFormDTO) {
        User user = userRepository.findByUsername(userFormDTO.getUsername());
        if (user.getRoles().contains(roleRepository.findRoleByName(Roles.ROLE_MEDIC.getAuthority()))) {
            fillSchedule(user);
        }
    }

    private void fillSchedule(User doctor) {
        LocalDateTime today = LocalDateTime.now().with(LocalTime.of(8, 0, 0));
        if (scheduleRepository.getAllByDoctorIs(doctor).isEmpty()) {
            for (int day = 0; day < 31; day++) {
                for (int hour = 0; hour < 12; hour++) {
                    Schedule schedule = new Schedule();
                    schedule.setDoctor(doctor);
                    schedule.setDatetime(today.plusDays(day).plusHours(hour));
                    schedule.setAvailable(true);
                    scheduleRepository.save(schedule);
                }
            }
        }
    }
}
