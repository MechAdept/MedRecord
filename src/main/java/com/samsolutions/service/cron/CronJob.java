package com.samsolutions.service.cron;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@EnableScheduling
public class CronJob {

    @Scheduled(cron = "0 0 20 * * *")
    public void fixedDelayTask(){

    }
}
