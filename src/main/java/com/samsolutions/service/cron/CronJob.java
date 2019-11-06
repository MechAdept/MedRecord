package com.samsolutions.service.cron;

import com.samsolutions.entity.Role;
import com.samsolutions.entity.Schedule;
import com.samsolutions.entity.User;
import com.samsolutions.repository.*;
import com.samsolutions.roles.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
@Transactional
public class CronJob {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    VisitRepository visitRepository;

    @Autowired
    RoleRepository roleRepository;

    @Scheduled(cron = "0 0 0-23 * * * ")
    public void blockSchedule() {
        Role role = roleRepository.findRoleByName(Roles.ROLE_MEDIC.getAuthority());
        List<User> doctors = userRepository.getAllByRolesIs(role);
        LocalDateTime from = LocalDateTime.now().with(LocalTime.of(0, 0, 0));
        LocalDateTime timeRange = from.plusHours(1);
        for (User doctor : doctors) {
            List<Schedule> schedules = scheduleRepository.getDayByDoctorAndDates(doctor, from, from.plusDays(1));
            for (Schedule schedule : schedules) {
                if (schedule.getDatetime().getHour() < timeRange.getHour()) {
                    schedule.setAvailable(null);
                    scheduleRepository.save(schedule);
                }
            }
        }
    }

    @Scheduled(cron = "0 0-59 21 * * * ")
    private void deleteOldSchedule() {
        LocalDateTime from = LocalDateTime.now().with(LocalTime.of(0, 0, 0));
        scheduleRepository.deleteAllByDatetimeBefore(from.plusDays(1));
    }

    @Scheduled(cron = "0 0 22 * * * ")
    private void addNewSchedule() {
        Role role = roleRepository.findRoleByName(Roles.ROLE_MEDIC.getAuthority());
        List<User> doctors = userRepository.getAllByRolesIs(role);
        for (User user : doctors) {
            List<Schedule> schedules = schedulePreparation();
            for (Schedule schedule : schedules) {
                schedule.setDoctor(user);
                scheduleRepository.save(schedule);
            }
        }
    }

    private List<Schedule> schedulePreparation() {
        List<Schedule> schedules = new ArrayList<>();
        LocalDateTime today = LocalDateTime.now().with(LocalTime.of(8, 0, 0));
        for (int i = 0; i < 12; i++) {
            Schedule schedule = new Schedule();
            schedule.setDatetime(today.plusHours(i));
            schedules.add(schedule);
        }
        return schedules;
    }
}
