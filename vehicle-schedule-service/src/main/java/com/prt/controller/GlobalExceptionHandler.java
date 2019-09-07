package com.prt.controller;

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

import com.prt.error.ApiError;
import com.prt.error.DataException;

@ControllerAdvice
@RequestMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
public class GlobalExceptionHandler {

    @ExceptionHandler({ TransactionSystemException.class })
    public ResponseEntity<ApiError> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
	if (ex.getCause().getCause() instanceof ConstraintViolationException) {
	    Set<ConstraintViolation<?>> constraintViolations = ((ConstraintViolationException) ex.getCause().getCause())
		    .getConstraintViolations();
	    List<String> errors = new ArrayList<String>();
	    constraintViolations.forEach(c -> errors.add(c.getPropertyPath() + ": " + c.getMessage()));
	    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
	    return new ResponseEntity<ApiError>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), "system issue");
	return new ResponseEntity<ApiError>(apiError, new HttpHeaders(), apiError.getStatus());
    }

    @ExceptionHandler({ DataException.class })
    public ResponseEntity<ApiError> handleDataException(DataException ex, WebRequest request) {
	List<String> errors = new ArrayList<String>();
	errors.add(ex.getProperty() + ex.getErrorMessage());
	ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(), errors);
	return new ResponseEntity<ApiError>(apiError, new HttpHeaders(), apiError.getStatus());
    }
}
