package com.user.exception;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;

public class ApiException {
    private HttpStatus status;
    private String message;
    private List<String> errors;

    public ApiException(HttpStatus status, String message, List<String> errors) {
	super();
	this.status = status;
	this.message = message;
	this.errors = errors;
    }

    public ApiException(HttpStatus status, String message, String error) {
	super();
	this.status = status;
	this.message = message;
	errors = Arrays.asList(error);
    }

    public HttpStatus getStatus() {
	return status;
    }

    public String getMessage() {
	return message;
    }

    public List<String> getErrors() {
	return errors;
    }

}
