package com.prt.util;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;

@Configuration
public class JmsConfig {

    @Autowired
    private ConnectionFactory connectionFactory;

    @Bean
    public JmsTemplate createTemplate() {
	JmsTemplate template = new JmsTemplate();
	template.setConnectionFactory(connectionFactory);
	template.setDefaultDestinationName("CREATE");
	template.setMessageConverter(messageConverter());
	return template;
    }

    @Bean
    public MessageConverter messageConverter() {
	return new ScheduleMessageConverter();
    }

}
