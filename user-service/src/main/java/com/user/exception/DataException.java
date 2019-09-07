package com.user.exception;

public class DataException extends RuntimeException {
    private String errorMessage;
    private String property;
    private static final long serialVersionUID = 1L;

    public DataException(String errorMessage, String property) {
	super();
	this.errorMessage = errorMessage;
	this.property = property;
    }

    public String getErrorMessage() {
	return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
    }

    public String getProperty() {
	return property;
    }

    public void setProperty(String property) {
	this.property = property;
    }
}
