package com.notify;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableJms
@EnableScheduling
@EnableJpaRepositories
@EnableBatchProcessing
@SpringBootApplication
public class Notification {

    public static void main(String[] args) {
	SpringApplication.run(Notification.class, args);
    }

}
