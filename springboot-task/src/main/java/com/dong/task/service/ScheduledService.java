package com.dong.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author dong
 * @date 2020/8/12 9:13
 */
@Service
public class ScheduledService {

    @Scheduled(cron = "0/4 * * * * MON-SAT")
    public void hello() {
        System.out.println("hello.....");
    }
}
