package com.projects.scheduletasksawaitility.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     *
     * fixedRate (Will run again after the method call)
     * fixedDelay (Will run again after the tasks for method was completed)
     * cron (for more sophisticated or complex scheduling of time)
     */
    @Scheduled(fixedRate = 5000)
    public void reportTime() {
        LOGGER.info("The time is: {}", dateFormat.format(new Date()));
    }
}
