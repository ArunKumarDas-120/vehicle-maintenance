package com.notify.jms;

import java.io.IOException;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

import com.common.model.MessageDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.notify.service.NotificationService;

@Component("DELETE")
public class DeleteScheduleListiner implements MessageListener {

    private final ObjectMapper objectMapper;
    private final NotificationService notificationService;

    public DeleteScheduleListiner(NotificationService notificationService, ObjectMapper objectMapper) {
	this.notificationService = notificationService;
	this.objectMapper = objectMapper;
    }

    @Override
    public void onMessage(Message message) {
	if (message instanceof TextMessage) {
	    try {
		MessageDto messageDto = objectMapper.readValue(((TextMessage) message).getText(), MessageDto.class);
		notificationService.deleteVehicleAndSchedule(messageDto);
	    } catch (JMSException | IOException e) {
		e.printStackTrace();
	    }
	}
    }

}
