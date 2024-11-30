package com.schoolmgmt.schoolMgmt.scheduling;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    // cron job, this will prrint this on console on every 5 secondes
    // if you want any mail scheduling task, then emplement heere
    @Scheduled(fixedRate = 5000)
    public void performTask() {
        System.out.println("Task is running...");
    }
}
