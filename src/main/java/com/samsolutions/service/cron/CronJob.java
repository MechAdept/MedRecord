package com.samsolutions.service.cron;

import com.samsolutions.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@EnableScheduling
public class CronJob {

    @Autowired
    private ScheduleService scheduleService;

    @Scheduled(cron = "0 0 0-23 * * * ")
    public void blockSchedule() {
        scheduleService.blockSchedule();
    }

    @Scheduled(cron = "0 0-59 21 * * * ")
    private void deleteOldSchedule() {
        scheduleService.deleteOldSchedule();
    }

    @Scheduled(cron = "0 0 22 * * * ")
    private void addNewSchedule() {
        scheduleService.addNewSchedule();
    }
}
