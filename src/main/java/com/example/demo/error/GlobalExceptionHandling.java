package com.example.demo.error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex, WebRequest request) {
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("Moughite Server Error", HttpStatus.INTERNAL_SERVER_ERROR.toString(), details);
		return new ResponseEntity(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	 @ExceptionHandler(RecordNotFoundException.class)
	    public final ResponseEntity<Object> handleUserNotFoundException(RecordNotFoundException ex, WebRequest request) {
	        List<String> details = new ArrayList<>();
	        details.add(ex.getLocalizedMessage());
	    	ErrorResponse error = new ErrorResponse("Moughite Server Error", HttpStatus.NOT_FOUND.toString(), details);
	        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
	    }

}
