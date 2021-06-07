package com.intech_global.javavacancy.testtask.publisher.service;

import com.intech_global.javavacancy.testtask.publisher.dto.Action;
import com.intech_global.javavacancy.testtask.publisher.dto.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class MessageFactory {

    private final Counter counter;

    public Message create() {
        Message message = new Message();
        message.setId(counter.getNextValue());

        long randLong = (long) (Math.random() * 1_000_000_000L);
        message.setMsisdn(convertToString(randLong));

        message.setAction(getRandAction());
        message.setTimestamp(Instant.now().getEpochSecond());
        return message;
    }

    private Action getRandAction() {
        int num = (int) (Math.random() * 2);
        return num == 0 ? Action.PURCHASE : Action.SUBSCRIPTION;
    }

    // if msisdnLong is 1234L, output should be "000001234"
    private String convertToString(long msisdnLong) {
        String nonFormattedStr = Long.toString(msisdnLong);
        int numOfZeros = 9 - nonFormattedStr.length();
        return "0".repeat(numOfZeros) + nonFormattedStr;
    }
}
