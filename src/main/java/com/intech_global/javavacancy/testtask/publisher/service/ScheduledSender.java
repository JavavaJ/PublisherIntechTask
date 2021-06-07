package com.intech_global.javavacancy.testtask.publisher.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduledSender {

    private final MessageSender messageSender;

    @Scheduled(fixedRate = 15000L)
    public void runScheduledPublishing() {
        messageSender.runMultipleThreads();
    }
}
