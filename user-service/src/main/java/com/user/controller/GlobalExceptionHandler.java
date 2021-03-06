package com.user.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import com.user.exception.ApiException;
import com.user.exception.DataException;

@ControllerAdvice
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
public class GlobalExceptionHandler {

    @ExceptionHandler({ TransactionSystemException.class })
    public ResponseEntity<ApiException> handleConstraintViolation(TransactionSystemException ex, WebRequest request) {
	if (ex.getCause().getCause() instanceof ConstraintViolationException) {
	    Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) ex.getCause().getCause())
		    .getConstraintViolations();
	    List<String> errors = new ArrayList<String>();
	    constraintViolations.forEach(c -> errors.add(c.getPropertyPath() + ": " + c.getMessage()));
	    ApiException apiError = new ApiException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
	    return new ResponseEntity<ApiException>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	ApiException apiError = new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(),
		"system issue");
	return new ResponseEntity<ApiException>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({ DataException.class })
    public ResponseEntity<ApiException> handleDataException(DataException ex, WebRequest request) {
	List<String> errors = new ArrayList<String>();
	errors.add(ex.getProperty() + ex.getErrorMessage());
	ApiException apiError = new ApiException(HttpStatus.BAD_REQUEST, ex.getErrorMessage(), errors);
	return new ResponseEntity<ApiException>(apiError,  apiError.getStatus());
    }
}
