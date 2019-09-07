package com.notify.jms;

import java.util.Map;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.jms.listener.DefaultMessageListenerContainer;

@Configuration
public class JMSConfiguration implements JmsListenerConfigurer {

    @Autowired
    private ConnectionFactory connectionFactory;
    @Autowired
    private Map<String, MessageListener> listinerConfig;

    @Override
    public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {

	listinerConfig.forEach((k, v) -> {
	    SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
	    endpoint.setId(k);
	    endpoint.setDestination("CREATE");
	    endpoint.setMessageListener(v);
	    endpoint.setSelector("MessageType=" + "'" + k + "'");
	    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
	    factory.setConnectionFactory(connectionFactory);
	    factory.setSubscriptionDurable(false);
	    factory.setPubSubDomain(false);
	    DefaultMessageListenerContainer container = factory.createListenerContainer(endpoint);
	    endpoint.setupListenerContainer(container);
	    registrar.registerEndpoint(endpoint, factory);
	});
    }

}
