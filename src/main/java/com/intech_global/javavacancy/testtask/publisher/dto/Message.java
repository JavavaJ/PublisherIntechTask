package com.intech_global.javavacancy.testtask.publisher.dto;

import lombok.Data;

@Data
public class Message {

    private Long id;
    private String msisdn;
    private Action action;
    private long timestamp;

}
