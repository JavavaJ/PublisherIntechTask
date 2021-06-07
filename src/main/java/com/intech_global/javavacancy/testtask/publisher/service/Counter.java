package com.intech_global.javavacancy.testtask.publisher.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class Counter {

    private final AtomicLong counter = new AtomicLong(1);

    public long getNextValue() {
        return counter.getAndIncrement();
    }


}
