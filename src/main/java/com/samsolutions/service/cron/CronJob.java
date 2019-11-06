package com.samsolutions.service.cron;

import com.samsolutions.entity.Schedule;
import com.samsolutions.entity.Ticket;
import com.samsolutions.repository.ScheduleRepository;
import com.samsolutions.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;

@Service
@EnableScheduling
public class CronJob {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Scheduled(cron = "0 0-59 0-23 * * * ")
    public void cleanSchedule() {
    }
//
//    private List<Schedule> getSchedule() {
//        LocalDateTime from = LocalDateTime.now().with(LocalTime.of(LocalTime.now().getHour(), 0, 0));
//        LocalDateTime to = from.plusDays(1).with(LocalTime.of(0, 0, 0));
//        List<Schedule> list = scheduleRepository.getAllBetweenDateTimes(from, to);
//        return list;
//    }
//
//    private void cleanTickets(List<Ticket> tickets) {
//        for (Ticket var:tickets) {
//            if(var.att)
//        }
//    }
}
