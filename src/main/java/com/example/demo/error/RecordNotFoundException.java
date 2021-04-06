package com.example.demo.error;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends RuntimeException {

	public RecordNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
