package com.prt.util;

import javax.jms.ConnectionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;

import com.common.model.MessageDto;
import com.common.model.UserDto;
import com.common.model.VehicleInfoTo;
import com.prt.event.ActionEvent;

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

    @Bean(name = {"ACTIONEVENT"})
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ActionEvent createActionEvent(MessageDto dto) {
	return new ActionEvent(dto);
    }

    @Bean(name = {"MESSAGE"})
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public MessageDto createMessageDto(UserDto user, VehicleInfoTo vehicleInfo, String messageSelector) {
	return new MessageDto(user, vehicleInfo, messageSelector);
    }

}
