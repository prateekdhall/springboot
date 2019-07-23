package com.springboot.crud.example.CrudAppException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentExceptionHandler {

	@ExceptionHandler(value = StudentNotFoundException.class)
	public ResponseEntity<Object> exception(StudentNotFoundException exception) {
		return new ResponseEntity<Object>("Student Not Found.", HttpStatus.NOT_FOUND);
	}
}
