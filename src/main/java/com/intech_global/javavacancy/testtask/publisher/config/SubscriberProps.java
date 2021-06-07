package com.intech_global.javavacancy.testtask.publisher.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "subscriber")
@Getter @Setter
public class SubscriberProps {

    private String url;

}
