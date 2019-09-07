package com.prt.util;

import java.util.Objects;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ScheduleMessageConverter implements MessageConverter {

    @Autowired
    private ObjectMapper mapper;

    @Override
    public Message toMessage(Object object, Session session) throws JMSException, MessageConversionException {
	object = Objects.requireNonNull(object);
	String payload = null;
	try {
	    payload = mapper.writeValueAsString(object);
	} catch (JsonProcessingException e) {
	    e.printStackTrace();
	}
	return session.createTextMessage(payload);
    }

    @Override
    public Object fromMessage(Message message) throws JMSException, MessageConversionException {
	// TODO Auto-generated method stub
	return null;
    }

}
