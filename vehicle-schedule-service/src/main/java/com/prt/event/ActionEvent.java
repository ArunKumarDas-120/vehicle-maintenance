package com.prt.event;

import org.springframework.context.ApplicationEvent;

public class ActionEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    public ActionEvent(Object source) {
	super(source);
	// TODO Auto-generated constructor stub
    }

}
