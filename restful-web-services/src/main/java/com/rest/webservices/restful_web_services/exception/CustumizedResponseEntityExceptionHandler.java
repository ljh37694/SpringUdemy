package com.rest.webservices.restful_web_services.exception;

import java.time.LocalDate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rest.webservices.restful_web_services.user.UserNotFoundException;

@ControllerAdvice
public class CustumizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorDetails> handleAllException(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),
				ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		String errorMessage = String.format("Total: %d, First Error: %s", 
				ex.getErrorCount(), ex.getFieldError().getDefaultMessage());
		
		ErrorDetails errorDetails = new ErrorDetails(LocalDate.now(),
				errorMessage, request.getDescription(false));
		
		return new ResponseEntity<Object>(errorDetails, HttpStatus.BAD_REQUEST);
	}
}
