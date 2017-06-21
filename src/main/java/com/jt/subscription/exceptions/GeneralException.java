package com.jt.subscription.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.jt.subscription.model.ErrorMessage;


@ControllerAdvice
@RestController
public class GeneralException  {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorMessage> toResponse(Throwable ex) {
		return new ResponseEntity<>(new ErrorMessage(ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}