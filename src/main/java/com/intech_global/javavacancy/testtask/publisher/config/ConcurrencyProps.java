package com.intech_global.javavacancy.testtask.publisher.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "sender")
@Getter @Setter
public class ConcurrencyProps {

    private Integer threadsNum;
}
