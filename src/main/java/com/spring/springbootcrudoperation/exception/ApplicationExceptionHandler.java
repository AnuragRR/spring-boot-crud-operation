package com.spring.springbootcrudoperation.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.springbootcrudoperation.response.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler {

	@Autowired
	private ResponseStructure<String> responseStructure;
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundException(IdNotFoundException exception){
		
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setStatusMessage(exception.getMsg());
		responseStructure.setData(null);
		
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatusCode.valueOf(200));
	}
	
}
