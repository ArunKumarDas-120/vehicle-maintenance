package com.notify.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfiguration {

    @Autowired
    private StepBuilderFactory stepBuilder;
    @Autowired
    private JobBuilderFactory jobs;

    @Bean
    public Job notificatonSenderJob() {
	Step day3Step = stepBuilder.get("day3").tasklet(firstNotificationTask()).build();
	Step day2Step = stepBuilder.get("day2").tasklet(secondNotificationTask()).build();
	Step day0Step = stepBuilder.get("day0").tasklet(thirdNotificationTask()).build();
	Step overdueStep = stepBuilder.get("overdue").tasklet(overdueNotificationTask()).build();
	return jobs.get("notificatonSenderJob").incrementer(new RunIdIncrementer()).start(day3Step).next(day2Step)
		.next(day0Step).next(overdueStep).build();
    }

    @Bean
    public Tasklet firstNotificationTask() {
	return new FirstNotificationTask();
    }

    @Bean
    public Tasklet secondNotificationTask() {
	return new SecondNotificationTask();
    }

    @Bean
    public Tasklet thirdNotificationTask() {
	return new ThirdNotificationTask();
    }

    @Bean
    public Tasklet overdueNotificationTask() {
	return new OverdueNotificationTask();
    }
}
