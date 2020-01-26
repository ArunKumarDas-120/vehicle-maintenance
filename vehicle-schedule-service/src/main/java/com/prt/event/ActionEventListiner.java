package com.prt.event;

import org.springframework.context.event.EventListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.common.model.MessageDto;

@Component
public class ActionEventListiner {

    private final JmsTemplate jmsTemplate;

    public ActionEventListiner(JmsTemplate jmsTemplate) {
	this.jmsTemplate = jmsTemplate;
    }

    @Async
    @EventListener(classes = { ActionEvent.class })
    public void onApplicationEvent(ActionEvent event) {
	Object source = event.getSource();
	if (source instanceof MessageDto) {
	    MessageDto messageDto = (MessageDto) source;
	    jmsTemplate.convertAndSend(messageDto, m -> {
		m.setStringProperty("MessageType", messageDto.getMessageSelector());
		return m;
	    });
	}

    }

}
