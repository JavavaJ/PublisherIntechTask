package com.intech_global.javavacancy.testtask.publisher.service;

import com.intech_global.javavacancy.testtask.publisher.config.ConcurrencyProps;
import com.intech_global.javavacancy.testtask.publisher.config.SubscriberProps;
import com.intech_global.javavacancy.testtask.publisher.dto.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageSender {

    private final RestTemplate restTemplate;
    private final SubscriberProps subscriber;
    private final MessageFactory messageFactory;
    private final ConcurrencyProps concurrencyProps;
    private ExecutorService executorService;


    public void send(Message message) {
        log.info("Message sent {}", message);
        restTemplate.postForEntity(
            subscriber.getUrl(),
            new HttpEntity<Message>(message),
            String.class);
    }

    public void runMultipleThreads() {
        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> send(messageFactory.create()));
        }
    }

    @PostConstruct
    public void initExecutorService() {
        executorService = Executors.newFixedThreadPool(concurrencyProps.getThreadsNum());
    }


}
